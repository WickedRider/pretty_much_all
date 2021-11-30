package ficha04.V2Ex6;

public class Fresco extends Alimento {
    private double precoKgEmbalamento;

    public Fresco(String descricao, String origem, double peso, double taxaIVA, double precoKg, double precoKgEmbalamento) {
        super(descricao, origem, peso, taxaIVA, precoKg);
        this.precoKgEmbalamento = precoKgEmbalamento;
    }

    public double getPrecoKgEmbalamento() {
        return precoKgEmbalamento;
    }

    public void setPrecoKgEmbalamento(float precoKgEmbalamento) {
        this.precoKgEmbalamento = precoKgEmbalamento;
    }

    @Override
    public String toString() {
        return "Tipo de produto: fresco; " + super.toString();
    }
}
