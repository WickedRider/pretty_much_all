package ficha04.V2Ex1;

public class Mamifero extends Animal {


    public Mamifero(String especie) {
        super(especie);
        meio = "terra";
    }

    @Override
    public String desloca() {
        return "Mamifero a deslocar-se!";
    }

    public String bebeLeite() {
        return "Mamifero bebe leite!";
    }

    @Override
    public String toString() {
        return "Mamifero : " + especie;
    }
}
