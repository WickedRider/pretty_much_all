package ficha04.Ex1;

public class Docente extends Pessoa{
    private int numMec;

    public Docente(String nome, int numMec) {
        super(nome);
        this.numMec = numMec;
    }

    public int getNumMec() {
        return numMec;
    }

    public void setNumMec(int numMec) {
        this.numMec = numMec;
    }

    public String missao() {
        return "ensinar";
    }

    @Override
    public String toString() {
        return "O " + getNome() + " com o número mecanografico " + getNumMec() + " tem uma missoa de " + missao();
    }
}
