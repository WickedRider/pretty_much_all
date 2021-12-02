package SupermercadoOnline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * txt to arraylisys - checked
 * arraylists to objFile - checked
 * read from objFile - checked
 * alternative to file creation (not first time) - 
 * login - 
 * make a purchase - 
 * store purchases - class is constructed, needed to be tested, purchases need to be stored in object file
 */


public class Supermercado implements Serializable{
    private String filePathObj="src/SupermercadoOnline/lojaObj.ser";
    private String filePathTxt="src/SupermercadoOnline/loja.txt";
    
    ArrayList<Cliente> clienteFreq;
    ArrayList<Cliente> clienteReg;
    ArrayList<Mobiliario> prodMobilia;
    ArrayList<Limpeza> prodLimpeza;
    ArrayList<Alimentares> prodAlimentares;
    ArrayList<Compras> compras;



    public Supermercado(){
        clienteFreq = new ArrayList<Cliente>();
        clienteReg = new ArrayList<Cliente>();
        prodMobilia = new ArrayList<Mobiliario>();
        prodLimpeza = new ArrayList<Limpeza>();
        prodAlimentares = new ArrayList<Alimentares>();
    }

    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args){
        Supermercado s = new Supermercado();
        s.start();
    }
    
    private void start(){
        File fTxt = new File(filePathTxt);
        File fObj = new File(filePathObj);
        boolean exit = false;
        int key = 0;
        Scanner sc = new Scanner(System.in);
        try{

            if(fObj.createNewFile()){
                lineParsing(fTxt, fObj);
            }else{
                fromObjFile(fObj);
                compras = new ArrayList<Compras>();
                Cliente currentCl = login();
                while(!exit){
                    System.out.println("Escolha uma das opcões para prosseguir:\n-1 -> Proceder a uma compra.\n-2 -> Verificar compras feitas.");
                    key = sc.nextInt();
                    switch (key) {
                        case 1:
                            makePurchase();

                            break;
                        case 2:


                            break;
                        default:
                            exit = false;
                            break;
                    }
                }
            }
            sc.close();
        } catch (IOException e){
            System.out.println("IOException.");
        } catch (Exception e){
            System.out.println("THIS EXCEPTION");
        }
        

    }

    
    
    private void makePurchase(){
        
    }
    
    
    private Cliente login(){
        Scanner sc = new Scanner(System.in);
        int hold = 0;
        String email = sc.nextLine();
        Cliente cte = new Cliente();
        for (int i = 0; i < email.length(); i++) {
            if(email.charAt(i) == '@')
            hold = i;
            if(email.charAt(i) == '.' && hold < i)
            System.out.println("INVALID EMAIL.");
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
                    hold = -2;
                    break;
                }
            }
        }
        sc.close();
        
        if(hold != -2 && hold != -1){
            System.out.println("Email inválido. Não está registado.");
            return null;
        }
        
        return cte;
    }
    
    /** 
     * @param f
     */
    private void lineParsing(File fTxt, File fObj) throws Exception{
        
        try{
            FileReader fr = new FileReader(fTxt);
            BufferedReader br = new BufferedReader(fr);
            String[] split;
            String check;
            
            while ( (check = br.readLine()) != null)
            {    
                split = check.split("§");
                //CLIENTES FREQUENTES
                if(split[0].equals("FREQ") && (split.length == 6)){
                    Cliente cl = new Cliente(split[1], split[2], split[3], Long.parseLong(split[4]), split[5]);
                    clienteFreq.add(cl);
                }
                //CLIENTES REGULARES
                if(split[0].equals("REG") && (split.length == 6)){
                    Cliente cl = new Cliente(split[1], split[2], split[3], Long.parseLong(split[4]), split[5]);
                    clienteReg.add(cl);
                }
                //PRODUTOS MOBILIARIOS
                if(split[0].equals("MOB") && (split.length == 7)){
                    String[] newSplit = split[2].split("x");
                    double[] split2 = new double[3];
                    int index=0;
                    for (String newString : newSplit) {
                        split2[index] = Double.parseDouble(newString);index++;
                    }
                    Mobiliario mb = new Mobiliario(Double.parseDouble(split[1]), split2, split[3], split[4], Double.parseDouble(split[5]), Integer.parseInt(split[6]));
                    prodMobilia.add(mb);
                }
                //PRODUTOS LIMPEZA
                if(split[0].equals("LIMP") && (split.length == 6)){
                    Limpeza lp = new Limpeza(Double.parseDouble(split[1]), split[2], split[3], Double.parseDouble(split[4]), Integer.parseInt(split[5]));
                    prodLimpeza.add(lp);
                }
                //PRODUTOS ALIMENTARES
                if(split[0].equals("ALIM") && (split.length == 7)){
                    Alimentares ali = new Alimentares(Double.parseDouble(split[1]), Double.parseDouble(split[2]), split[3], split[4], Double.parseDouble(split[5]), Integer.parseInt(split[6]));
                    prodAlimentares.add(ali);
                }
            }
            
            writeToObjectFile(fObj);
            
            //System.out.println(clienteFreq+"\n");
            // System.out.println(clienteReg+"\n");
            // System.out.println(prodMobilia+"\n");
            // System.out.println(prodLimpeza+"\n");
            // System.out.println(prodAlimentares+"\n");
            
            br.close();
        } catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND.");
        } catch (IOException e) {
            System.out.println("IOEXCEPTION.");
        }
    }
    
    
    private void writeToObjectFile(File f) throws Exception{
        
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream ooS = new ObjectOutputStream(fos);
            
            ooS.writeObject(clienteFreq);
            ooS.writeObject(clienteReg);
            ooS.writeObject(prodMobilia);
            ooS.writeObject(prodLimpeza);
            ooS.writeObject(prodAlimentares);
            ooS.writeObject(compras);
            ooS.close();
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oiS = new ObjectInputStream(fis);
            System.out.println(" " + oiS.readObject()+ "\n");
            System.out.println(" " + oiS.readObject()+ "\n");
            System.out.println(" " + oiS.readObject()+ "\n");
            System.out.println(" " + oiS.readObject()+ "\n");
            System.out.println(" " + oiS.readObject()+ "\n");
            
            oiS.close();
        } catch(ClassNotFoundException e) {
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    private void fromObjFile(File f) throws Exception{
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oiS = new ObjectInputStream(fis);

            clienteFreq = (ArrayList<Cliente>)oiS.readObject();
            clienteReg = (ArrayList<Cliente>)oiS.readObject();
            prodMobilia = (ArrayList<Mobiliario>)oiS.readObject();
            prodLimpeza = (ArrayList<Limpeza>)oiS.readObject();
            prodAlimentares = (ArrayList<Alimentares>)oiS.readObject();


            fis.close();
            oiS.close();
        } catch (ClassNotFoundException e){

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
