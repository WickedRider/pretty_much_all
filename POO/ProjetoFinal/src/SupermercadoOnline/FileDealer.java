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

public class FileDealer implements Serializable {
    // LAPTOP
    // File fTxt = new File("POO/ProjetoFinal/src/SupermercadoOnline/loja.txt");
    // File fObj = new File("POO/ProjetoFinal/src/SupermercadoOnline/lojaObj.obj");
    // DESKTOP
    File fTxt = new File("src/SupermercadoOnline/loja.txt");
    File fObj = new File("src/SupermercadoOnline/lojaObj.obj");

    ArrayList<Cliente> clienteFreq;
    ArrayList<Cliente> clienteReg;
    ArrayList<Mobiliario> prodMobilia;
    ArrayList<Limpeza> prodLimpeza;
    ArrayList<Alimentares> prodAlimentares;
    ArrayList<Compras> compras;

    public FileDealer() {
        clienteFreq = new ArrayList<Cliente>();
        clienteReg = new ArrayList<Cliente>();
        prodMobilia = new ArrayList<Mobiliario>();
        prodLimpeza = new ArrayList<Limpeza>();
        prodAlimentares = new ArrayList<Alimentares>();
    }


/**
 * 
 * @param fTxt : ficheiro associado ao path do ficheiro txt
 * @param fObj : ficheiro associado ao path do ficherio obj
 * @param f : construtor a ser retornado com a informação adquirida
 * @return f : contrutor retornado
 */

    public FileDealer lineParsing(File fTxt, File fObj, FileDealer f){
        
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
                    Cliente cl = new Cliente(split[1], split[2], split[3], Long.parseLong(split[4]), split[5], compras, true);
                    clienteFreq.add(cl);
                }
                //CLIENTES REGULARES
                if(split[0].equals("REG") && (split.length == 6)){
                    Cliente cl = new Cliente(split[1], split[2], split[3], Long.parseLong(split[4]), split[5], compras, false);
                    clienteReg.add(cl);
                }
                //PRODUTOS MOBILIARIOS
                if(split[0].equals("MOB") && (split.length == 7)){
                    // DIMENSAO 
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
            
            f.setClienteFreq(clienteFreq);
            f.setClienteReg(clienteReg);
            f.setProdMobilia(prodMobilia);
            f.setProdLimpeza(prodLimpeza);
            f.setProdAlimentares(prodAlimentares);
            
            br.close();
        } catch (FileNotFoundException e){
            System.out.println("FILE NOT FOUND.");
        } catch (IOException e) {
            System.out.println("IOEXCEPTION.");
        }

        return f;
    }
    
    
    
    /** 
     * @param f : ficheiro associado ao path em que vai ser escrita a informação
     * @param f1 : construtor que guarda toda a informação
     * @param cl : cliente atual (login)
     */
    public void writeToObjectFile(File f, FileDealer f1, Cliente cl){
        
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream ooS = new ObjectOutputStream(fos);
            int a = 0;
            if((a = findCliente(cl, f1.getClienteFreq())) != -1){
                f1.getClienteFreq().get(a).setCmp(cl.getCmp());
            }
            if((a = findCliente(cl, f1.getClienteReg())) != -1){
                f1.getClienteReg().get(a).setCmp(cl.getCmp());
            }

            ooS.writeObject(f1.getClienteFreq());
            ooS.writeObject(f1.getClienteReg());
            ooS.writeObject(f1.getProdMobilia());
            ooS.writeObject(f1.getProdLimpeza());
            ooS.writeObject(f1.getProdAlimentares());
            ooS.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    /** 
     * @param c : cliente atual
     * @param arrc : array de clientes, onde vai ser procurado c
     * @return int : index do cliente a procurar, -1 se não encontrar
     */
    private int findCliente(Cliente c, ArrayList<Cliente> arrc){
        int a = -1;

        for (int i = 0; i < arrc.size(); i++) {
            if(c.getMail().equals(arrc.get(0).getMail())){
                return i;
            }
        }

        return a;
    }

    
    /** 
     * @param f : ficheiro associado ao path do ficheiro a ler
     * @param f1 : construtor que vai receber a informação do ficheiro
     * @return FileDealer : construtor com informação
     */
    @SuppressWarnings("unchecked")
    public FileDealer fromObjFile(File f, FileDealer f1){
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream oiS = new ObjectInputStream(fis);

            f1.setClienteFreq((ArrayList<Cliente>)oiS.readObject());
            f1.setClienteReg((ArrayList<Cliente>)oiS.readObject());
            f1.setProdMobilia((ArrayList<Mobiliario>)oiS.readObject());
            f1.setProdLimpeza((ArrayList<Limpeza>)oiS.readObject());
            f1.setProdAlimentares((ArrayList<Alimentares>)oiS.readObject());

            fis.close();
            oiS.close();
        } catch (ClassNotFoundException e){

        } catch (Exception e){
            e.printStackTrace();
        }
        return f1;
    }




    
    /** 
     * @return File : ficheiro associado ao txt
     */
    public File getFTxt() {
        return this.fTxt;
    }

    
    /** 
     * @param fTxt [File]: definir ficheiro associado ao txt
     */
    public void setFTxt(File fTxt) {
        this.fTxt = fTxt;
    }

    
    /** 
     * @return File : ficheiro assiciado ao obj
     */
    public File getFObj() {
        return this.fObj;
    }

    
    /** 
     * @param fObj [File]: definir ficheiro assiciado ao obj
     */
    public void setFObj(File fObj) {
        this.fObj = fObj;
    }    

    
    /** 
     * @return ArrayList<Cliente> : array de clientes frequentes
     */
    public ArrayList<Cliente> getClienteFreq() {
        return this.clienteFreq;
    }

    
    /** 
     * @param clienteFreq [ArrayList Cliente ] : definir array de clientes frequentes
     */
    public void setClienteFreq(ArrayList<Cliente> clienteFreq) {
        this.clienteFreq = clienteFreq;
    }

    
    /** 
     * @return ArrayList<Cliente> : array de clientes regulares
     */
    public ArrayList<Cliente> getClienteReg() {
        return this.clienteReg;
    }

    
    /** 
     * @param clienteReg [ArrayList Cliente ]: definir array de clientes regulares
     */
    public void setClienteReg(ArrayList<Cliente> clienteReg) {
        this.clienteReg = clienteReg;
    }

    
    /** 
     * @return ArrayList<Mobiliario> : array de produtos de mobiliario
     */
    public ArrayList<Mobiliario> getProdMobilia() {
        return this.prodMobilia;
    }

    
    /** 
     * @param prodMobilia [ArrayList Mobiliario ]: definir array de mobiliario
     */
    public void setProdMobilia(ArrayList<Mobiliario> prodMobilia) {
        this.prodMobilia = prodMobilia;
    }

    
    /** 
     * @return ArrayList<Limpeza> : array de produtos de Limpeza 
     */
    public ArrayList<Limpeza> getProdLimpeza() {
        return this.prodLimpeza;
    }

    
    /** 
     * @param prodLimpeza [ArrayList Limpeza ]: definir array de Limpeza
     */
    public void setProdLimpeza(ArrayList<Limpeza> prodLimpeza) {
        this.prodLimpeza = prodLimpeza;
    }

    
    /** 
     * @return ArrayList<Alimentares> : array de produtos Alimentares
     */
    public ArrayList<Alimentares> getProdAlimentares() {
        return this.prodAlimentares;
    }

    
    /** 
     * @param prodAlimentares [ArrayList Alimentares ]: definir array de Alimentares
     */
    public void setProdAlimentares(ArrayList<Alimentares> prodAlimentares) {
        this.prodAlimentares = prodAlimentares;
    }

    
    /** 
     * @return ArrayList<Compras> : array de compras
     */
    public ArrayList<Compras> getCompras() {
        return this.compras;
    }

    
    /** 
     * @param compras [ArrayList Compras ]: definir array de Compras
     */
    public void setCompras(ArrayList<Compras> compras) {
        this.compras = compras;
    }

}
