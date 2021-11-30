package SupermercadoOnline;




public class Alimentares extends Produtos{
    protected double calPerCem;
    protected double fatPercent;

    public Alimentares(double calPerCem, double fatPercent, String identificador, String nomeProd, double precoUni, int stock){
        super(identificador, nomeProd, precoUni, stock);
        this.calPerCem = calPerCem;
        this.fatPercent = fatPercent;
    }


    @Override
    public String toString() {
        return super.toString() +
            " calPerCem='" + getCalPerCem() + "'" +
            ", fatPercent='" + getFatPercent() + "'" +
            "}";
    }

    public double getCalPerCem() {
        return this.calPerCem;
    }

    public void setCalPerCem(double calPerCem) {
        this.calPerCem = calPerCem;
    }

    public double getFatPercent() {
        return this.fatPercent;
    }

    public void setFatPercent(double fatPercent) {
        this.fatPercent = fatPercent;
    }

}
