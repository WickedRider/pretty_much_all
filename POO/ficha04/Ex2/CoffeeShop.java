package ficha04.Ex2;

public class CoffeeShop {
    public static void main(String[] args) {
        Coffee c = new Coffee();
        CoffeeExpresso ce = new CoffeeExpresso("cheio");
        Leite l = new Leite();
        ExpumaDeLeite el = new ExpumaDeLeite();

        System.out.println(c);
        System.out.println(ce);
        System.out.println(l);
        System.out.println(el);
    }
}
