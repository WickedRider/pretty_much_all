package SupermercadoOnline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * txt to arraylisys - checked
 * arraylists to objFile - checked
 * login - checked
 * read from objFile - checked
 * alternative to file creation (not first time) - checked
 * store purchases - checked
 * make a purchase - checked
 * promos - FOR DOMINGO
 */


public class Supermercado implements Serializable{
    
    ArrayList<Cliente> clienteFreq;
    ArrayList<Cliente> clienteReg;
    ArrayList<Mobiliario> prodMobilia;
    ArrayList<Limpeza> prodLimpeza;
    ArrayList<Alimentares> prodAlimentares;
    ArrayList<Produtos> prods;
    FileDealer fd1;
    
    public Supermercado(){
        clienteFreq = new ArrayList<Cliente>();
        clienteReg = new ArrayList<Cliente>();
        prodMobilia = new ArrayList<Mobiliario>();
        prodLimpeza = new ArrayList<Limpeza>();
        prodAlimentares = new ArrayList<Alimentares>();
    }
    
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Supermercado s = new Supermercado();
        s.start();
    }
    
    private void start(){
        ArrayList<Compras> compras;
        Compras compraAtual = new Compras();
        prods = new ArrayList<Produtos>();

        fd1 = new FileDealer();
        File fTxt = fd1.getFTxt();
        File fObj = fd1.getFObj();
        
        boolean exit = false;
        int key = 0;
        Scanner sc = new Scanner(System.in);
        
        try{

            if(fObj.createNewFile()){
                compras = new ArrayList<Compras>();
                compras.add(compraAtual);
                fd1 = fd1.lineParsing(fTxt, fObj, fd1, compras);

            }else{
                fd1 = fd1.fromObjFile(fObj, fd1);
            }

            clienteFreq = fd1.getClienteFreq();
            clienteReg = fd1.getClienteReg();
            prodMobilia = fd1.getProdMobilia();
            prodLimpeza = fd1.getProdLimpeza();
            prodAlimentares = fd1.getProdAlimentares();

            

            Cliente currentCl = login();
            while(currentCl.getNome() == null){
                currentCl = login();

            }
            compras = currentCl.getCmp();
            while(!exit){
                System.out.println("\nEscolha uma das opcões para prosseguir:\n-1 -> Proceder a uma compra.\n-2 -> Verificar compras feitas.\nQualquer outro valor -> para sair.");
                key = sc.nextInt();

                switch (key) {
                    case 1:
                        makePurchase(key, compraAtual);
                        currentCl.setCmp(compras);
                        System.out.println(currentCl.toString());
                        compras.set(compras.size()-1, compraAtual);
                        break;
                    case 2:
                        if(compras.get(0).getPriceTot() == 0){
                            System.out.println("Nao existem compras registadas.");
                            continue;
                        }

                        double price = 0;
                        System.out.println("Compras efetudas por " + currentCl.getNome() + " :\n");
                        
                        compras.set(compras.size()-1, compraAtual);
                        
                        for (Compras c : compras) {
                            price = (double)Math.round(c.getPriceTot()*100)/100;
                            System.out.println("Preco Total = "+price+", Produtos: "+c.toString());
                        } 
                        
                        

                        break;
                    default:
                        compras.add(compraAtual);
                        fd1.writeToObjectFile(fObj, fd1);
                        exit = true;

                        break;
                }
            }
            sc.close();
            
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } 
        
    }

    
    
    private Compras makePurchase(int key, Compras compraAtual){
        key = intCheck(key, true);
        
        switch (key) {
            case 1:
                printAll(key);
                break;

            case 2:
                printAll(key);
                buyMobilia(compraAtual);
                break;

            case 3:
                printAll(key);
                buyLimpeza(compraAtual);
                break;

            case 4:
                printAll(key);
                buyAlimentares(compraAtual);
                break;  

            default:
                System.out.println("Invalid Input.");
                makePurchase(key, compraAtual);
                break;
        }

        return compraAtual;
    }
    
    private Cliente login(){
        Scanner sc = new Scanner(System.in);
        int hold = 0;
        System.out.print("\nInsira um email válido para prosseguir: ");
        String email = sc.next();
        Cliente cte = new Cliente();
        for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@'){
                hold = i;
            }
            if(email.charAt(i) == '.' && hold > i){
                System.out.println("INVALID EMAIL.");
            }
        }
        for (Cliente c : clienteFreq) {
            if(c.getMail().equals(email)){
                System.out.println("Logged In. Welcome " + c.getNome() + " enjoy your shopping!");
                hold = -1;  cte = c;
                break;
            }
        }
        if(hold!=-1){
            for (Cliente c : clienteReg) {
                if(c.getMail().equals(email)){
                    System.out.println("Logged In. Welcome " + c.getNome() + " enjoy your shopping!");
                    cte = c;
                    hold = -1;
                    break;
                }
            }
        }
        
        if(hold != -1){
            System.out.println("Email inválido. Não está registado.\n Por favor, insira o email correto.");
        }
        
        return cte;
    }
    
    private int intCheck(int k, boolean state){
        Scanner sc = new Scanner(System.in);
        try{
            if(state)
                System.out.println("1 -> Mostrar Produtos disponiveis. \n2 -> Comprar Produto de Mobiliario. \n3 -> Comprar Produtos de Limpeza. \n4 -> Comprar Produtos Alimentares");
            k = sc.nextInt();
        } catch(Exception e){
            System.out.println("Input invalido. Tente Novamente.");
            intCheck(k, state);
        }
        return k;
    }

    private void printAll(int key){

        if(key==2 || key == 1){
            System.out.println("STOCK: \nProdutos de Mobiliario: ");
            for (int i = 0; i < prodMobilia.size(); i++) {
                System.out.println(i + " -> " + prodMobilia.get(i));
            }
        }

        if(key==3 || key == 1){
            System.out.println("Produtos de Limpeza: ");
            for (int i = 0; i < prodLimpeza.size(); i++) {
                System.out.println(i+" -> "+prodLimpeza.get(i));
            }
        }

        if(key==4 || key == 1){
            System.out.println("Produtos Alimentares: ");
            for(int i = 0; i < prodAlimentares.size(); i++) {
                System.out.println(i+" -> "+prodAlimentares.get(i));
            }
        }
    }

    private void buyMobilia(Compras compra) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o número do produto que pretende comprar: ");
        int prod = 0; prod = intCheck(prod, false);
        
        
        int stock = 0;
        System.out.println("Quantos " + prodMobilia.get(prod).getNomeProd() + " gostaria de comprar. Stock atual: " + prodMobilia.get(prod).getStock());
        stock = intCheck(stock, false);
        double price = 0;
        if(stock > prodMobilia.get(prod).getStock()) {
            System.out.println("Não há stock suficiente para essa compra.");
            buyMobilia(compra);
        }else if(stock == 0){
            System.out.println("Compra Invalida. Compras requerem no minimo a compra de 1.");
            buyMobilia(compra);
        }else {
            prodMobilia.get(prod).setStock((prodMobilia.get(prod).getStock() - stock));
            price = stock * prodMobilia.get(prod).getPrecoUni() * 1.23;
            price = (double)Math.round(price * 100) / 100;
            System.out.println("Preco da compra (com IVA): " + price + "GETPRICE" + compra.getPriceTot());
            compra.setPriceTot(compra.getPriceTot()+price);

            Mobiliario mb = new Mobiliario(prodMobilia.get(0).getPeso(), prodMobilia.get(0).getDimensao(), prodMobilia.get(0).getIdentificador(),
            prodMobilia.get(0).getNomeProd(), prodMobilia.get(0).getPrecoUni(), stock);
            
            prods.add(mb);
            compra.setProd(prods);
        }
    }

    private void buyLimpeza(Compras compra) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o número do produto que pretende comprar: ");
        int prod = 0; prod = intCheck(prod, false);
        
        
        int stock = 0;
        System.out.println("Quantos " + prodLimpeza.get(prod).getNomeProd() + " gostaria de comprar. Stock atual: " + prodLimpeza.get(prod).getStock());
        stock = intCheck(stock, false);
        double price = 0;
        if(stock > prodLimpeza.get(prod).getStock()) {
            System.out.println("Não há stock suficiente para essa compra.");
            buyLimpeza(compra);
        } else if(stock == 0){
            System.out.println("Compra Invalida. Compras requerem no minimo a compra de 1.");
            buyLimpeza(compra);
        }else {
            prodLimpeza.get(prod).setStock((prodMobilia.get(prod).getStock() - stock));
            price = stock * prodLimpeza.get(prod).getPrecoUni() * 1.23;
            price = (double)Math.round(price * 100) / 100;
            System.out.println("Preco da compra (com IVA): " + price + "GETPRICE" + compra.getPriceTot());
            compra.setPriceTot(compra.getPriceTot()+price);

            Limpeza lp = new Limpeza(prodLimpeza.get(0).getGTox(), prodLimpeza.get(0).getIdentificador(), prodLimpeza.get(0).getNomeProd(),
             prodLimpeza.get(0).getPrecoUni(), stock);
            
            prods.add(lp);
            compra.setProd(prods);
        }
    }

    private void buyAlimentares(Compras compra) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o número do produto que pretende comprar: ");
        int prod = 0; prod = intCheck(prod, false);
        
        
        int stock = 0;
        System.out.println("Quantos " + prodAlimentares.get(prod).getNomeProd() + " gostaria de comprar. Stock atual: " + prodAlimentares.get(prod).getStock());
        stock = intCheck(stock, false);
        double price = 0;
        if(stock > prodAlimentares.get(prod).getStock()) {
            System.out.println("Não há stock suficiente para essa compra.");
            buyLimpeza(compra);
        }else if(stock == 0){
            System.out.println("Compra Invalida. Compras requerem no minimo a compra de 1.");
            buyAlimentares(compra);
        } else {
            prodAlimentares.get(prod).setStock((prodMobilia.get(prod).getStock() - stock));
            price = stock * prodAlimentares.get(prod).getPrecoUni() * 1.23;
            price = (double)Math.round(price * 100) / 100;
            System.out.println("Preco da compra (com IVA): " + price + "GETPRICE" + compra.getPriceTot());
            compra.setPriceTot(compra.getPriceTot()+price);

            Alimentares lp = new Alimentares(prodAlimentares.get(0).getCalPerCem(),prodAlimentares.get(0).fatPercent, prodAlimentares.get(0).getIdentificador(), prodAlimentares.get(0).getNomeProd(),
             prodAlimentares.get(0).getPrecoUni(), stock);
            
            prods.add(lp);
            compra.setProd(prods);
        }
    }


}
