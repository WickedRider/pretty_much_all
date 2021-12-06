package SupermercadoOnline;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * txt to arraylisys - checked
 * arraylists to objFile - checked
 * login - checked
 * read from objFile - checked
 * alternative to file creation (not first time) - checked
 * store purchases - checked
 * make a purchase - checked
 * delivery prices - checked
 * promos:
 *          take4pay3 - checked
 *          pagueMenos - to be done, prob segunda
 *          MISSING DATES - beg and end
 *          remove random shit, only dates
 */


public class Supermercado implements Serializable{
    
    ArrayList<Cliente> clienteFreq;
    ArrayList<Cliente> clienteReg;
    ArrayList<Mobiliario> prodMobilia;
    ArrayList<Limpeza> prodLimpeza;
    ArrayList<Alimentares> prodAlimentares;
    ArrayList<Produtos> prods;
    FileDealer fd1;
    Random r;
    Miscellaneous mcll;


    public Supermercado(){
        clienteFreq = new ArrayList<Cliente>();
        clienteReg = new ArrayList<Cliente>();
        prodMobilia = new ArrayList<Mobiliario>();
        prodLimpeza = new ArrayList<Limpeza>();
        prodAlimentares = new ArrayList<Alimentares>();
        mcll = new Miscellaneous();
        r = new Random();
    }
    
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        Supermercado s = new Supermercado();
        s.start();
    }
    
    private void start(){
        ArrayList<Compras> compras = new ArrayList<Compras>();
        Compras compraAtual = new Compras();
        prods = new ArrayList<Produtos>();
        
        Boolean hPromo = r.nextBoolean();
        System.out.println(hPromo);

        fd1 = new FileDealer();
        File fTxt = fd1.getFTxt();
        File fObj = fd1.getFObj();
        
        boolean exit = false;
        int key = 0;
        Scanner sc = new Scanner(System.in);
        
        try{

            if(fObj.createNewFile()){
                fd1 = fd1.lineParsing(fTxt, fObj, fd1);
                
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
            if(currentCl.getCmp() == null){
                compras.add(null);
                currentCl.setCmp(compras);
                System.out.println("NULL");
            }
            compras = currentCl.getCmp();
            while(!exit){
                System.out.println("\nEscolha uma das opcões para prosseguir:\n-1 -> Proceder a uma compra.\n-2 -> Verificar compras feitas.\nQualquer outro valor -> para sair.");
                key = mcll.getInt();

                switch (key) {
                    case 1:
                        compraAtual = makePurchase(key, compraAtual, currentCl.isFreq(), hPromo);
                        compras.set(compras.size()-1, compraAtual);
                        currentCl.setCmp(compras);
                        System.out.println("\n" + compras + "\n");
                        break;
                    case 2:
                        if(currentCl.getCmp().get(0) != null){
                            if(currentCl.getCmp().get(0).getPriceTot() == 0){
                                System.out.println("Nao existem compras registadas.");
                                continue;
                            }

                            double price = 0;
                            System.out.println("Compras efetudas por " + currentCl.getNome() + " :\n");
                            

                            for (Compras c : currentCl.getCmp()) {
                                price = (double)Math.round(c.getPriceTot()*100)/100;
                                if(price != 0){
                                    System.out.println("Preco Total = "+price+", Produtos: "+c.toString());
                                }
                            }
                        } else {
                            System.out.println("Nao existem compras registadas.");
                        }
                            
                        

                        break;
                    default:
                        compras.set(compras.size()-1,compraAtual);
                        currentCl.setCmp(compras);
                        fd1.writeToObjectFile(fObj, fd1, currentCl);
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

    
    
    private Compras makePurchase(int key, Compras compraAtual, Boolean clientType, Boolean hasPromo){
        key = mcll.intCheck(key, true);
        int promo = 0;
        if(hasPromo){
            promo = 2 + (int)(Math.random() * ((4-2)+1));
            System.out.println(promo);
        }
        //Min + (int)(Math.random() * ((Max - Min) + 1))
        switch (key) {
            case 1:
                printAll(key);
                makePurchase(key, compraAtual, clientType, hasPromo);

            case 2:
                printAll(key);
                if(hasPromo && promo == 2){
                    System.out.println("Promoção ativa.");
                    hasPromo = true;
                }
                compraAtual.buyMobilia(compraAtual, clientType, prodMobilia, prods, hasPromo);
                break;

            case 3:
                printAll(key);
                if(hasPromo && promo == 3){
                    System.out.println("Promoção ativa.");
                    hasPromo = true;
                }
                compraAtual.buyLimpeza(compraAtual, clientType, prodLimpeza, prods, hasPromo);
                break;

            case 4:
                printAll(key);
                if(hasPromo && promo == 4){
                    System.out.println("Promoção ativa.");
                    hasPromo = true;
                }
                compraAtual.buyAlimentares(compraAtual, clientType, prodAlimentares, prods, hasPromo);
                break;  

            default:
                System.out.println("Invalid Input.");
                makePurchase(key, compraAtual, clientType, hasPromo);
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
}
