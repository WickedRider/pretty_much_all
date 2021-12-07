package SupermercadoOnline;

import java.util.ArrayList;

public class Promocao extends Compras{
    protected Boolean typeP3T4;

    public Promocao(ArrayList<Produtos> prod, double priceTot, Boolean typeP3T4){
        super(prod, priceTot);
        this.typeP3T4 = typeP3T4;
    }
    public Promocao(){}

    public Boolean isTypeP3T4() {
        return this.typeP3T4;
    }

    public Boolean getTypeP3T4() {
        return this.typeP3T4;
    }

    public void setTypeP3T4(Boolean typeP3T4) {
        this.typeP3T4 = typeP3T4;
    }

    
    

    @Override
    public String toString() {
        String str = super.toString();
        if(isTypeP3T4()) {
            str += ", Promocao do tipo leve 4 pague 3.";
        } else {
            str += ", Promocao do tipo pague menos.";
        }
        return str;
    }

    public int take4pay3(int stock){
        int sub = (int)Math.floor(stock / 4.0);
        System.out.println("ASDWAFAWFAWFAW\n\n\n\n");
        return (stock-sub);
    }

    public double pagueMenos(int stock, double price){
        double per =  1;
        for (int i = 0; i < stock; i++) {
            if(i == 10){    
                break;
            }
            per = per - 0.05;
            System.out.println(per);
        }
        per = 1 - (double)Math.round(per*100)/100;
        System.out.println(per+"\n\n");
        price = (double)Math.round((price * per) * 100) / 100;
        System.out.println("Promocao aplicada: Pague-Menos.\n Obteve um desconto de: " + per*100 + " %.");
        return price;
    }

}
