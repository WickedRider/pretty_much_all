package ficha04.V2Ex1;

public class Ave extends Animal {


    public Ave(String especie) {
        super(especie);
        meio = "ar";
    }

    @Override
    public String desloca() {
        return "Ave a deslocar-se!";
    }

    @Override
    public String toString() {
        return "Ave: " + especie;
    }
}
