package SupermercadoOnline;

import java.util.ArrayList;

public class Promocao extends Compras{
    protected Boolean typeP3T4;

    public Promocao(ArrayList<Produtos> prod, double priceTot, Boolean typeP3T4){
        super(prod, priceTot);
        this.typeP3T4 = typeP3T4;
    }


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



}
