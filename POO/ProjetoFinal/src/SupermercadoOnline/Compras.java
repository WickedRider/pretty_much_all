package SupermercadoOnline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Compras implements Serializable{
    protected double priceTot;
    ArrayList<Produtos> prod;
    Miscellaneous mcll = new Miscellaneous();
    Promocao prm;

    public Compras(ArrayList<Produtos> prod, double priceTot){
        prod = new ArrayList<Produtos>();
        this.priceTot = priceTot;
    }

    public Compras(){
        
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        String string = "";
        
        for (Produtos p : getProd()) {
            string += p.toString();
        }
        return string;
    }


    
    /** 
     * @return double
     */
    public double getPriceTot() {
        return this.priceTot;
    }

    
    /** 
     * @param priceTot
     */
    public void setPriceTot(double priceTot) {
        this.priceTot = priceTot;
    }

    
    /** 
     * @return ArrayList<Produtos>
     */
    public ArrayList<Produtos> getProd() {
        return this.prod;
    }

    
    /** 
     * @param prod
     */
    public void setProd(ArrayList<Produtos> prod) {
        this.prod = prod;
    }
    
    
    
    /** 
     * @param compra
     * @param cType
     * @param prodMobilia
     * @param prods
     * @param promo
     */
    public void buyMobilia(Compras compra, Boolean cType, ArrayList<Mobiliario> prodMobilia, ArrayList<Produtos> prods, int promo) {
        Scanner sc = new Scanner(System.in);
        int prod = 0; prod = mcll.getInt("Insira o número do produto que pretende comprar: ");
        
        while(prod > prodMobilia.size()-1 || prod < 0) {
            System.out.println("Valor inválido. Produto não existe");
            prod = mcll.getInt("Insira o número do produto que pretende comprar: ");
        }
        
        int stock = 0;
        System.out.println("Quantos " + prodMobilia.get(prod).getNomeProd() + " gostaria de comprar. Stock atual: " + prodMobilia.get(prod).getStock());
        stock = mcll.intCheck(stock, false);
        double price = 0;
        if(stock > prodMobilia.get(prod).getStock()) {
            System.out.println("Não há stock suficiente para essa compra.");
            buyMobilia(compra, cType, prodMobilia, prods, promo);
        }else if(stock == 0){
            System.out.println("Compra Invalida. Compras requerem no minimo a compra de 1.");
            buyMobilia(compra, cType, prodMobilia, prods, promo);
        }else {
            prodMobilia.get(prod).setStock((prodMobilia.get(prod).getStock() - stock));
            
            if(prodMobilia.get(prod).getPeso() >= 15){
                price += 10;
                System.out.println("Preco de entrega ao domicilio: 10.0");
            }
            if(promo == 0){
                prm = new Promocao(prods, priceTot, false);
                price = (double)Math.round((stock * prodMobilia.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                price = prm.pagueMenos(stock, price);
            }else if(promo == 1){
                prm = new Promocao(prods, priceTot, true);
                int i = prm.take4pay3(stock);
                price = (double)Math.round((i * prodMobilia.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("\n\nPreco da compra, com aplicação da promoção leve 4 pague 3 (com IVA): " + price + ". Dos " + stock + " pagou " + i);
            } else {
                price = (double)Math.round((stock * prodMobilia.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("Preco da compra (com IVA): " + price);
                
            }
            compra.setPriceTot(compra.getPriceTot()+price);
            System.out.println("Preco da compra (com IVA): " + price);

            Mobiliario mb = new Mobiliario(prodMobilia.get(prod).getPeso(), prodMobilia.get(prod).getDimensao(), prodMobilia.get(prod).getIdentificador(),
            prodMobilia.get(prod).getNomeProd(), prodMobilia.get(prod).getPrecoUni(), stock);
            
            prods.add(mb);
            compra.setProd(prods);
        }
    }

    
    /** 
     * @param compra
     * @param cType
     * @param prodLimpeza
     * @param prods
     * @param promo
     */
    public void buyLimpeza(Compras compra, Boolean cType, ArrayList<Limpeza> prodLimpeza, ArrayList<Produtos> prods, int promo) {
        Scanner sc = new Scanner(System.in);
        int prod = 0; prod = mcll.getInt("Insira o número do produto que pretende comprar: ");
        
        while(prod > prodLimpeza.size()-1 || prod < 0) {
            System.out.println("Valor inválido. Produto não existe");
            prod = mcll.getInt("Insira o número do produto que pretende comprar: ");
        }
        
        int stock = 0;
        System.out.println("Quantos " + prodLimpeza.get(prod).getNomeProd() + " gostaria de comprar. Stock atual: " + prodLimpeza.get(prod).getStock());
        stock = mcll.intCheck(stock, false);
        double price = 0;
        if(stock > prodLimpeza.get(prod).getStock()) {
            System.out.println("Não há stock suficiente para essa compra.");
            buyLimpeza(compra, cType, prodLimpeza, prods, promo);
        } else if(stock == 0){
            System.out.println("Compra Invalida. Compras requerem no minimo a compra de 1.");
            buyLimpeza(compra, cType, prodLimpeza, prods, promo);
        }else {
            prodLimpeza.get(prod).setStock((prodLimpeza.get(prod).getStock() - stock));
            if(promo == 0){
                prm = new Promocao(prods, priceTot, false);
                price = (double)Math.round((stock * prodLimpeza.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                price = prm.pagueMenos(stock, price);
            }else if(promo == 1){
                prm = new Promocao(prods, priceTot, true);
                int i = prm.take4pay3(stock);
                price = (double)Math.round((i * prodLimpeza.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("\n\nPreco da compra, com aplicação da promoção leve 4 pague 3 (com IVA): " + price + ". Dos " + stock + " pagou " + i);
            } else {
                price = (double)Math.round((stock * prodLimpeza.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("Preco da compra (com IVA): " + price);
                
            }
            
            if(cType){
                if(price < 40){
                    price += 15;
                    System.out.println("Preco de entrega ao domicilio: 15");
                }
            } else{
                price += 20;
                System.out.println("Preco de entrega ao domicilio: 20");
            }

            System.out.println("Preco da compra (com IVA): " + price);
            compra.setPriceTot(compra.getPriceTot()+price);

            Limpeza lp = new Limpeza(prodLimpeza.get(prod).getGTox(), prodLimpeza.get(prod).getIdentificador(), prodLimpeza.get(prod).getNomeProd(),
             prodLimpeza.get(prod).getPrecoUni(), stock);
            
            prods.add(lp);
            compra.setProd(prods);
        }
    }

    
    /** 
     * @param compra
     * @param cType
     * @param prodAlimentares
     * @param prods
     * @param promo
     */
    public void buyAlimentares(Compras compra, Boolean cType, ArrayList<Alimentares> prodAlimentares, ArrayList<Produtos> prods, int promo) {
        Scanner sc = new Scanner(System.in);
        int prod = 0; prod = mcll.getInt("Insira o número do produto que pretende comprar: ");
        while(prod > prodAlimentares.size()-1 || prod < 0) {
            System.out.println("Valor inválido. Produto não existe");
            prod = mcll.getInt("Insira o número do produto que pretende comprar: ");
        }
        
        int stock = 0;
        System.out.println("Quantos " + prodAlimentares.get(prod).getNomeProd() + " gostaria de comprar. Stock atual: " + prodAlimentares.get(prod).getStock());
        stock = mcll.intCheck(stock, false);
        double price = 0;
        if(stock > prodAlimentares.get(prod).getStock()) {
            System.out.println("Não há stock suficiente para essa compra.");
            buyAlimentares(compra, cType, prodAlimentares, prods, promo);
        }else if(stock == 0){
            System.out.println("Compra Invalida. Compras requerem no minimo a compra de 1.");
            buyAlimentares(compra, cType, prodAlimentares, prods, promo);
        } else {
            prodAlimentares.get(prod).setStock((prodAlimentares.get(prod).getStock() - stock));
            if(cType){
                if(price < 40){
                    price += 15;
                    System.out.println("Preco de entrega ao domicilio: 15");
                }
            } else{
                price += 20;
                System.out.println("Preco de entrega ao domicilio: 20");
            }

            if(promo == 0){
                prm = new Promocao(prods, priceTot, false);
                price = (double)Math.round((stock * prodAlimentares.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                price = prm.pagueMenos(stock, price);
            }else if(promo == 1){
                prm = new Promocao(prods, priceTot, true);
                int i = prm.take4pay3(stock);
                price = (double)Math.round((i * prodAlimentares.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("\n\nPreco da compra, com aplicação da promoção leve 4 pague 3 (com IVA): " + price + ". Dos " + stock + " pagou " + i);
            } else {
                price = (double)Math.round((stock * prodAlimentares.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("Preco da compra (com IVA): " + price);
                
            }
            
            Alimentares lp = new Alimentares(prodAlimentares.get(prod).getCalPerCem(),prodAlimentares.get(prod).fatPercent, prodAlimentares.get(prod).getIdentificador(), prodAlimentares.get(0).getNomeProd(),
            prodAlimentares.get(prod).getPrecoUni(), stock);
            
            
            if(promo != 0 && promo != 1){

                compra.setPriceTot(compra.getPriceTot()+price);
                compra.setProd(prods);
            } else {
                compra.setPriceTot(prm.getPriceTot()+price);
                price = (double)Math.round((stock * prodAlimentares.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                compra.setProd(prods);
            }
            
            prods.add(lp);
        }
    }



    
}
