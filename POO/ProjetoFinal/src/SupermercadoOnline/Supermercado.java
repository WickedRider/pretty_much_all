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
 *          pagueMenos - checked
 *          MISSING DATES - checked
 * 
 * ALMOST FINISHED
 * only needs some perfecting and shit
 * JAVADOCS lmao
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
    Promocao prm;
    private Boolean hPromo = true;

    public Supermercado(){
        clienteFreq = new ArrayList<Cliente>();
        clienteReg = new ArrayList<Cliente>();
        prodMobilia = new ArrayList<Mobiliario>();
        prodLimpeza = new ArrayList<Limpeza>();
        prodAlimentares = new ArrayList<Alimentares>();
        mcll = new Miscellaneous();
        r = new Random();
    }
    
    
    
    public static void main(String[] args){
        Supermercado s = new Supermercado();
        s.start();
    }
    
    private void start(){
        Compras compraAtual = new Compras();
        ArrayList<Compras> compras = new ArrayList<Compras>();
        prods = new ArrayList<Produtos>();
        
        
        fd1 = new FileDealer();
        File fTxt = fd1.getFTxt();
        File fObj = fd1.getFObj();

        Data dt = new Data();
        Data dInicial = new Data(12, 11, 2021);
        Data dFinal = new Data(25, 11, 2021);
        
        System.out.println("Defina a data corrente: \n\n\n\n");
            dt.setData(dt);
        
        if(dInicial.getAno() != dt.getAno() || dInicial.getMes() != dt.getMes()){
            hPromo = false;
        } else if (dInicial.getDia() > dt.getDia() && dFinal.getDia() < dt.getDia() && dt.getMes() != dInicial.getMes()) {
            hPromo = false;
        } 
        // escolher qual dos produtos vai ter promoção
        int promo = 0;
        if(hPromo){
            promo = 2 + (int)(Math.random() * ((4-2)+1));
            System.out.println(promo+"\n\n\n");
        }

        Boolean exit = false;
        Boolean proceed = false;
        int key = 0;
        Scanner sc = new Scanner(System.in);
        
        try{

            if(fObj.createNewFile()){//so acontece na primeira vez
                fd1 = fd1.lineParsing(fTxt, fObj, fd1);
                
            }else{// ler do ficheiro de objetos
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
            }
            compras = currentCl.getCmp();

            while(!exit){
                key = mcll.getInt("\nEscolha uma das opcões para prosseguir:\n-1 -> Proceder a uma compra.\n-2 -> Verificar compras feitas.\nQualquer outro valor -> para sair.");

                switch (key) {
                    case 1:
                        compraAtual = makePurchase(key, compraAtual, currentCl.isFreq(), promo);
                        compras.set(compras.size()-1, compraAtual);
                        currentCl.setCmp(compras);
                        proceed = true;
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
                                if(c.getProd() == null){
                                    break;
                                }
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
                        if(!proceed){
                            System.out.println(compras+"\n\n\n\n\n\n\n");
                            compras.set(compras.size()-1,compraAtual);
                        }else {
                            System.out.println(compras + "\n\n\n");
                            compras.add(null);
                        }
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

    
    
    
    /** 
     * 
     * @param key [int]: não funciona exatamente como parametro, apenas para nao criar outro inteiro
     * @param compraAtual [Compras]: Objeto do tipo Compras, guarda toda a informação por run
     * @param clientType [Boolean]: true = frequente; false = regular
     * @param promo [int]: Define qual das promoções será aplicada
     * @return Compras [ArrayList Compras ]: ArrayList<Compras> guarda as compras efetudas por cliente
     */
    private Compras makePurchase(int key, Compras compraAtual, Boolean clientType, int promo){
        key = mcll.intCheck(key, true);
        //Min + (int)(Math.random() * ((Max - Min) + 1))
        switch (key) {
            case 1:
                printAll(key);
                makePurchase(key, compraAtual, clientType, promo);

            case 2:
                printAll(key);
                if(hPromo && promo == 2){
                    System.out.println("Promoção ativa.");
                    promo = 0 + (int)(Math.random() * ((1-0)+1));
                    hPromo = false;
                }else{promo=3;}

                compraAtual.buyMobilia(compraAtual, clientType, prodMobilia, prods, promo);
                break;

            case 3:
                printAll(key);
                if(hPromo && promo == 3){
                    System.out.println("Promoção ativa.");
                    promo = 0 + (int)(Math.random() * ((1-0)+1));
                    System.out.println("\\\\\\\\\\1213123131313131313    "+promo);
                    hPromo = false;
                }else{promo=3;}

                compraAtual.buyLimpeza(compraAtual, clientType, prodLimpeza, prods, promo);
                break;

            case 4:
                printAll(key);
                if(hPromo && promo == 4){
                    System.out.println("Promoção ativa.");
                    promo = 0 + (int)(Math.random() * ((1-0)+1));
                    hPromo = false;
                }else{promo=3;}

                compraAtual.buyAlimentares(compraAtual, clientType, prodAlimentares, prods, promo);
                break;  

            default:
                System.out.println("Invalid Input.");
                makePurchase(key, compraAtual, clientType, promo);
                break;
        }

        return compraAtual;
    }
    
    
    /** 
     * @return Cliente  que fez login
     */
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
    
    

    
    /** 
     * Função usada para mostrar todo o stock ou de um certo tipo de produtos
     * @param key [int] define se mostra todo o stock ou parte
     */
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
