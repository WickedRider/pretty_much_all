package ficha04.V2Ex6;

public class Transformado extends Alimento {
    protected double pesoTransformado;
    protected double precoKgTransformado;

    public Transformado(String descricao, String origem, double peso, double taxaIVA, double precoKg, double pesoTransformado,
                        double precoKgTransformado) {
        super(descricao, origem, peso, taxaIVA, precoKg);
        this.pesoTransformado = pesoTransformado;
        this.precoKgTransformado = precoKgTransformado;
    }

    public double getPesoTransformado() {
        return pesoTransformado;
    }

    public void setPesoTransformado(float pesoTransformado) {
        this.pesoTransformado = pesoTransformado;
    }

    public double getPrecoKgTransformado() {
        return precoKgTransformado;
    }

    public void setPrecoKgTransformado(float precoKgTransformado) {
        this.precoKgTransformado = precoKgTransformado;
    }

    @Override
    public String toString() {
        return super.toString() + "Peso bruto (transformado): " + pesoTransformado + "; Preco: " + precoKgTransformado + ";";
    }
}
