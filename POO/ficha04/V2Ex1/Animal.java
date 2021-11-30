package ficha04.V2Ex1;

public class Animal {
    protected String especie;
    protected String meio;

    public Animal() {

    }

    public Animal(String especie) {
        this();
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getMeio() {
        return meio;
    }

    public void setMeio(String meio) {
        this.meio = meio;
    }

    public String desloca() {
        return "Animal a deslocar-se!";
    }

    @Override
    public String toString() {
        return "Animal: " + especie;
    }
}
