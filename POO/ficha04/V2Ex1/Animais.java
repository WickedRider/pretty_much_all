package ficha04.V2Ex1;

import java.util.ArrayList;

public class Animais {
    ArrayList<Animal> animais;

    public static void main(String[] args) {
        Animais a = new Animais();
        a.start();
    }

    public Animais() {
        animais = new ArrayList<>();
    }

    public void start() {
        System.out.println("--START--");

        Animal a = new Animal("cao");
        System.out.println(a);

        Mamifero m = new Mamifero("gato");
        System.out.println(m);

        Ave e = new Ave("aguia");
        System.out.println(e);

        System.out.println("------------");

        animais.add(a);
        animais.add(m);
        animais.add(e);

        for (Animal t : animais) {
            System.out.println(t);

            if (t.getMeio() == "terra") {
                Mamifero x = (Mamifero) t;
                x.bebeLeite();
            }
        }
        System.out.println("--END--");
    }
}
