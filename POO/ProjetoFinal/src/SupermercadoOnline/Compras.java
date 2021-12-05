package SupermercadoOnline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Compras implements Serializable{
    protected double priceTot;
    ArrayList<Produtos> prod;
    Miscellaneous mcll = new Miscellaneous();


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
    
    
    public void buyMobilia(Compras compra, Boolean cType, ArrayList<Mobiliario> prodMobilia, ArrayList<Produtos> prods, Boolean promo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o número do produto que pretende comprar: ");
        int prod = 0; prod = mcll.getInt();
        
        while(prod > prodMobilia.size()-1 || prod < 0) {
            System.out.println("Valor inválido. Produto não existe");
            System.out.println("Insira o número do produto que pretende comprar: ");
            prod = mcll.getInt();
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
            if(!promo){
                price = (double)Math.round((stock * prodMobilia.get(prod).getPrecoUni() * 1.23) * 100) / 100;
            }else {
                int i = take4pay3(stock);
                price = (double)Math.round((i * prodMobilia.get(prod).getPrecoUni() * 1.23) * 100) / 100;
            }
            compra.setPriceTot(compra.getPriceTot()+price);
            System.out.println("Preco da compra (com IVA): " + price);

            Mobiliario mb = new Mobiliario(prodMobilia.get(0).getPeso(), prodMobilia.get(0).getDimensao(), prodMobilia.get(0).getIdentificador(),
            prodMobilia.get(0).getNomeProd(), prodMobilia.get(0).getPrecoUni(), stock);
            
            prods.add(mb);
            compra.setProd(prods);
        }
    }

    public void buyLimpeza(Compras compra, Boolean cType, ArrayList<Limpeza> prodLimpeza, ArrayList<Produtos> prods, Boolean promo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o número do produto que pretende comprar: ");
        int prod = 0; prod = mcll.getInt();
        
        while(prod > prodLimpeza.size()-1 || prod < 0) {
            System.out.println("Valor inválido. Produto não existe");
            System.out.println("Insira o número do produto que pretende comprar: ");
            prod = mcll.getInt();
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
            if(!promo){
                price = (double)Math.round((stock * prodLimpeza.get(prod).getPrecoUni() * 1.23) * 100) / 100;
            }else {
                int i = take4pay3(stock);
                price = (double)Math.round((i * prodLimpeza.get(prod).getPrecoUni() * 1.23) * 100) / 100;
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

            Limpeza lp = new Limpeza(prodLimpeza.get(0).getGTox(), prodLimpeza.get(0).getIdentificador(), prodLimpeza.get(0).getNomeProd(),
             prodLimpeza.get(0).getPrecoUni(), stock);
            
            prods.add(lp);
            compra.setProd(prods);
        }
    }

    public void buyAlimentares(Compras compra, Boolean cType, ArrayList<Alimentares> prodAlimentares, ArrayList<Produtos> prods, Boolean promo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira o número do produto que pretende comprar: ");
        int prod = 0; prod = mcll.getInt();
        while(prod > prodAlimentares.size()-1 || prod < 0) {
            System.out.println("Valor inválido. Produto não existe");
            System.out.println("Insira o número do produto que pretende comprar: ");
            prod = mcll.getInt();
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

            if(!promo){
                price = (double)Math.round((stock * prodAlimentares.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("Preco da compra (com IVA): " + price);
            }else {
                int i = take4pay3(stock);
                price = (double)Math.round((i * prodAlimentares.get(prod).getPrecoUni() * 1.23) * 100) / 100;
                System.out.println("\n\nPreco da compra, com aplicação da promoção leve 4 pague 3 (com IVA): " + price + ". Dos " + stock + " pagou " + i);
            }

            compra.setPriceTot(compra.getPriceTot()+price);

            Alimentares lp = new Alimentares(prodAlimentares.get(0).getCalPerCem(),prodAlimentares.get(0).fatPercent, prodAlimentares.get(0).getIdentificador(), prodAlimentares.get(0).getNomeProd(),
             prodAlimentares.get(0).getPrecoUni(), stock);
            
            
            prods.add(lp);
            compra.setProd(prods);
        }
    }


    private int take4pay3(int stock){
        int sub = (int)Math.floor(stock / 4.0);

        return (stock-sub);
    }


    

}
