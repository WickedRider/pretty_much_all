package ficha04.V2Ex6;

public class Alimento {
    protected String descricao;
    protected String origem;
    protected double peso;
    protected double taxaIVA;
    protected double precoKg;

    public Alimento(String descricao, String origem, double peso, double taxaIVA, double precoKg) {
        this.descricao = descricao;
        this.origem = origem;
        this.peso = peso;
        this.taxaIVA = taxaIVA;
        this.precoKg = precoKg;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public double getTaxaIVA() {
        return taxaIVA;
    }

    public void setTaxaIVA(int taxaIVA) {
        this.taxaIVA = taxaIVA;
    }

    public double getPrecoKg() {
        return precoKg;
    }

    public void setPrecoKg(float precoKg) {
        this.precoKg = precoKg;
    }

    @Override
    public String toString() {
        return "Descricao: " + descricao + "; Origem: " + origem + "; PesoKG: " + peso + "; TaxaIVA: " + taxaIVA +
                "; Preco: " + precoKg + ";";
    }
}
