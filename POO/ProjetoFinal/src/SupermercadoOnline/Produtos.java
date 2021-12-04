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
     * @return String
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
     * @return String
     */
    public String getIdentificador() {
        return this.identificador;
    }

    
    /** 
     * @param identificador
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    
    /** 
     * @return String
     */
    public String getNomeProd() {
        return this.nomeProd;
    }

    
    /** 
     * @param nomeProd
     */
    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    
    /** 
     * @return double
     */
    public double getPrecoUni() {
        return this.precoUni;
    }

    
    /** 
     * @param precoUni
     */
    public void setPrecoUni(double precoUni) {
        this.precoUni = precoUni;
    }

    
    /** 
     * @return int
     */
    public int getStock() {
        return this.stock;
    }

    
    /** 
     * @param stock
     */
    public void setStock(int stock) {
        this.stock = stock;
    }



}
