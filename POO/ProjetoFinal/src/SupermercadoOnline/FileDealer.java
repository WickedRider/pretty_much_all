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
     * @param f
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
    
    
    public void writeToObjectFile(File f, FileDealer f1){
        
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream ooS = new ObjectOutputStream(fos);
            
            ooS.writeObject(f1.getClienteFreq());
            ooS.writeObject(f1.getClienteReg());
            ooS.writeObject(f1.getProdMobilia());
            ooS.writeObject(f1.getProdLimpeza());
            ooS.writeObject(f1.getProdAlimentares());
            // ooS.writeObject(f1.getCompras());
            ooS.close();
            // FileInputStream fis = new FileInputStream(f);
            // ObjectInputStream oiS = new ObjectInputStream(fis);
            // System.out.println(" " + oiS.readObject()+ "\n");
            // System.out.println(" " + oiS.readObject()+ "\n");
            // System.out.println(" " + oiS.readObject()+ "\n");
            // System.out.println(" " + oiS.readObject()+ "\n");
            // System.out.println(" " + oiS.readObject()+ "\n");
            // System.out.println("COMPRAS:" + oiS.readObject()+ "\n");
            // oiS.close();
            ooS.close();
        } // catch(ClassNotFoundException e) {
            
        // }
         catch(Exception e){
            e.printStackTrace();
        }
    }
    
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
            // f1.setCompras((ArrayList<Compras>)oiS.readObject());

            fis.close();
            oiS.close();
        } catch (ClassNotFoundException e){

        } catch (Exception e){
            e.printStackTrace();
        }
        return f1;
    }




    public File getFTxt() {
        return this.fTxt;
    }

    public void setFTxt(File fTxt) {
        this.fTxt = fTxt;
    }

    public File getFObj() {
        return this.fObj;
    }

    public void setFObj(File fObj) {
        this.fObj = fObj;
    }    

    public ArrayList<Cliente> getClienteFreq() {
        return this.clienteFreq;
    }

    public void setClienteFreq(ArrayList<Cliente> clienteFreq) {
        this.clienteFreq = clienteFreq;
    }

    public ArrayList<Cliente> getClienteReg() {
        return this.clienteReg;
    }

    public void setClienteReg(ArrayList<Cliente> clienteReg) {
        this.clienteReg = clienteReg;
    }

    public ArrayList<Mobiliario> getProdMobilia() {
        return this.prodMobilia;
    }

    public void setProdMobilia(ArrayList<Mobiliario> prodMobilia) {
        this.prodMobilia = prodMobilia;
    }

    public ArrayList<Limpeza> getProdLimpeza() {
        return this.prodLimpeza;
    }

    public void setProdLimpeza(ArrayList<Limpeza> prodLimpeza) {
        this.prodLimpeza = prodLimpeza;
    }

    public ArrayList<Alimentares> getProdAlimentares() {
        return this.prodAlimentares;
    }

    public void setProdAlimentares(ArrayList<Alimentares> prodAlimentares) {
        this.prodAlimentares = prodAlimentares;
    }

    public ArrayList<Compras> getCompras() {
        return this.compras;
    }

    public void setCompras(ArrayList<Compras> compras) {
        this.compras = compras;
    }

}
