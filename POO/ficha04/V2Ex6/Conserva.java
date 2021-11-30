package ficha04.V2Ex6;

public class Conserva extends Transformado {
    private double precoKgConserva;

    public Conserva(String descricao, String origem, double peso, double taxaIVA, double precoKg, double pesoTransformado,
                    double precoKgTransformado, double precoKgConserva) {
        super(descricao, origem, peso, taxaIVA, precoKg, pesoTransformado, precoKgTransformado);
        this.precoKgConserva = precoKgConserva;
    }

    public double getPrecoKgConserva() {
        return precoKgConserva;
    }

    public void setPrecoKgConserva(float precoKgConserva) {
        this.precoKgConserva = precoKgConserva;
    }

    @Override
    public String toString() {
        return "Tipo de produto: conserva; " + super.toString();

    }
}
