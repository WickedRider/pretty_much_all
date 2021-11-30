package ficha04.Ex2;

public class Drink {
    protected String nome;
    protected int temperatura;
    protected int quantidade;

    public Drink(String nome, int temperatura, int quantidade) {
        this.nome = nome;
        this.temperatura = temperatura;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pediu um/uma " + this.nome + " de " + this.quantidade + "ml a " + this.temperatura + " graus!";
    }
}
