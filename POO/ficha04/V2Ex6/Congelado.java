package ficha04.V2Ex6;

public class Congelado extends Transformado {
    public Congelado(String descricao, String origem, double peso, double taxaIVA, double precoKg, double pesoTransformado,
                     double precoKgTransformado) {
        super(descricao, origem, peso, taxaIVA, precoKg, pesoTransformado, precoKgTransformado);
    }

    @Override
    public String toString() {
        return "Tipo de produto: congelado; " + super.toString();
    }
}
