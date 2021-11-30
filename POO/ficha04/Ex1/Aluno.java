package ficha04.Ex1;

public class Aluno extends Pessoa {
    private int numAluno;

    public Aluno(String nome, int numAluno) {
        super(nome);
        this.numAluno = numAluno;
    }

    public int getNumAluno() {
        return numAluno;
    }
    public void setNumAluno(int numAluno) {
        this.numAluno = numAluno;
    }

    public String missao() {
        return "aprender";
    }

    @Override
    public String toString() {
        return "O " + getNome() + " com o número de aluno " + getNumAluno() + " tem uma missoa de " + missao();
    }
}
