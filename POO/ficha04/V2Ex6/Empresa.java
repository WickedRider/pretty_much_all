package ficha04.V2Ex6;

import java.util.ArrayList;

public class Empresa {
    ArrayList<Alimento> alimentos;

    private static final double taxaIVA = 0.23;

    public Empresa() {
        alimentos = new ArrayList<>();
    }

    public static void main(String[] args) {
        Empresa a = new Empresa();
        a.start();
    }

    public void start() {
        Fresco f1 = new Fresco("Alface linda", "terra", 0.25, taxaIVA, 1.59, 0.20);
        Congelado c1 = new Congelado("pizza pepperoni", "pt", 1, taxaIVA, 3, 0.5, 1.2);
        Conserva cv1 = new Conserva("atum mal cheiroso", "mar atlantico", 0.45, taxaIVA, 2.5, 0.3, 0.5, 0.2);

        alimentos.add(f1);
        alimentos.add(c1);
        alimentos.add(cv1);

        for (Alimento a: alimentos) {
            System.out.println(a);
        }
    }
}
