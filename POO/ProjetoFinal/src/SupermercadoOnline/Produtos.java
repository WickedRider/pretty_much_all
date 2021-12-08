package SupermercadoOnline;

import java.io.Serializable;

public class Produtos implements Serializable{
    protected String identificador;
    protected String nomeProd;
    protected double precoUni;
    protected int stock;

    public Produtos(String identificador, String nomeProd, double precoUni, int stock){
        this.identificador = identificador;
        this.nomeProd = nomeProd;
        this.precoUni = precoUni;
        this.stock = stock;
    }

    
    /** 
     * @return String : produto em string
     */
    @Override
    public String toString() {
        return "{" +
            " identificador = '" + getIdentificador() + "' " +
            ", nomeProd = '" + getNomeProd() + "' " +
            ", precoUni = '" + getPrecoUni() + "' " +
            ", stock = '" + getStock() + "' " +
            ",";
    }

    
    /** 
     * @return String : identificador
     */
    public String getIdentificador() {
        return this.identificador;
    }

    
    /** 
     * @param identificador [String]: definir identificador
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    
    /** 
     * @return String : nome do Produto
     */
    public String getNomeProd() {
        return this.nomeProd;
    }

    
    /** 
     * @param nomeProd [String]: definir nome do Produto
     */
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    
    /** 
     * @return double : preco por unidade
     */
    public double getPrecoUni() {
        return this.precoUni;
    }

    
    /** 
     * @param precoUni [double]: definir preco por unidade
     */
    public void setPrecoUni(double precoUni) {
        this.precoUni = precoUni;
    }

    
    /** 
     * @return int : stock
     */
    public int getStock() {
        return this.stock;
    }

    
    /** 
     * @param stock [int]: definir stock disponivel
     */
    public void setStock(int stock) {
        this.stock = stock;
    }



}
