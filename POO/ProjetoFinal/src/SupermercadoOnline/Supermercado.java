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
 * read from objFile - in progress, missing compras
 * alternative to file creation (not first time) - in progress, missing compras
 * store purchases - class is constructed, needed to be tested, purchases need to be stored in object file
 * make a purchase - working on rn
 * promos - no ideas yet
 */


public class Supermercado implements Serializable{
    
    ArrayList<Cliente> clienteFreq;
    ArrayList<Cliente> clienteReg;
    ArrayList<Mobiliario> prodMobilia;
    ArrayList<Limpeza> prodLimpeza;
    ArrayList<Alimentares> prodAlimentares;
    ArrayList<Compras> compras;
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
        fd1 = new FileDealer();
        File fTxt = fd1.getFTxt();
        File fObj = fd1.getFObj();

        boolean exit = false;
        int key = 0;
        Scanner sc = new Scanner(System.in);
        try{

            if(fObj.createNewFile()){
                fd1 = fd1.lineParsing(fTxt, fObj, fd1);
                System.out.println("!!!!!!!!!"+fd1.getClienteFreq());

            }else{
                fd1 = fd1.fromObjFile(fObj, fd1);
                System.out.println("!!!!"+fd1.getClienteFreq());

            }

            clienteFreq = fd1.getClienteFreq();
            clienteReg = fd1.getClienteReg();
            prodMobilia = fd1.getProdMobilia();
            prodLimpeza = fd1.getProdLimpeza();
            prodAlimentares = fd1.getProdAlimentares();
            compras = new ArrayList<Compras>();

            Cliente currentCl = login();
            while(currentCl.getNome() == null){
                currentCl = login();

            }

            while(!exit){
                System.out.println("\nEscolha uma das opcões para prosseguir:\n-1 -> Proceder a uma compra.\n-2 -> Verificar compras feitas.\nQualquer valor -> para sair.");
                key = sc.nextInt();

                switch (key) {
                    case 1:
                        makePurchase(compras, key);

                        break;
                    case 2:


                        break;
                    default:
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

    
    
    private void makePurchase(ArrayList<Compras> cmp, int key){
        Compras compraAtual = new Compras();
        key = intCheck(key);

        switch (key) {
            case 1:
                printAll();
                break;

            case 2:
                

                break;

            case 3:
                

                break;

            case 4:
                

                break;  

            default:
                break;
        }


    }
    
    private Cliente login(){
        Scanner sc = new Scanner(System.in);
        int hold = 0;
        System.out.print("\nInsira um email válido para prosseguir: ");
        String email = sc.next();
        Cliente cte = new Cliente();
        Boolean proceed = false;
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
    
    private int intCheck(int k){
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("1 -> Mostrar Produtos disponiveis. \n2 -> Comprar Produto de Mobiliario. \n3 -> Comprar Produtos de Limpeza. \n4 -> Comprar Produtos Alimentares");
            k = sc.nextInt();
        } catch(Exception e){
            e.printStackTrace();
        }
        return k;
    }

    private void printAll(){
        System.out.println("\nProdutos de Mobiliario: ");
        for (int i = 0; i < prodMobilia.size(); i++) {
            System.out.println(i + " -> " + prodMobilia.get(i));
        }
        System.out.println("Produtos de Limpeza: ");
        for (int i = 0; i < prodLimpeza.size(); i++) {
            System.out.println(i+" -> "+prodLimpeza.get(i));
        }
        System.out.println("Produtos Alimentares: ");
        for(int i = 0; i < prodAlimentares.size(); i++) {
            System.out.println(i+" -> "+prodAlimentares.get(i));
        }
    }
}
