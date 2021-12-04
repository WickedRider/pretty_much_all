package SupermercadoOnline;

import java.io.Serializable;
import java.util.ArrayList;

public class Compras implements Serializable{
    protected double priceTot;
    ArrayList<Produtos> prod;
    
    public Compras(ArrayList<Produtos> prod, double priceTot){
        prod = new ArrayList<Produtos>();
        this.priceTot = priceTot;
    }
    public Compras(){
        
    }

    @Override
    public String toString() {
        String string = "";
        for (Produtos p : getProd()) {
            string += p.toString();
        }
        return string;
    }


    public double getPriceTot() {
        return this.priceTot;
    }

    public void setPriceTot(double priceTot) {
        this.priceTot = priceTot;
    }

    public ArrayList<Produtos> getProd() {
        return this.prod;
    }

    public void setProd(ArrayList<Produtos> prod) {
        this.prod = prod;
    }
   

   
}
