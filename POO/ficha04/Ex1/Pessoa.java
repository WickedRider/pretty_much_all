package ficha04.Ex1;

public class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    protected String comunica() {
        return this.nome + " a comunicar.";
    }

    @Override
    public String toString() {
        return "";
    }
}
