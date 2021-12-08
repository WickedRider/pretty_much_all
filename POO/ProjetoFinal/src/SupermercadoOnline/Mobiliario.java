package SupermercadoOnline;



public class Mobiliario extends Produtos{
    protected double peso;
    protected double[] dimensao;    //[ altura , largura , profundidade ]

    public Mobiliario(double peso, double[] dimensao, String identificador, String nomeProd, double precoUni, int stock){
        super(identificador, nomeProd, precoUni, stock);
        this.peso = peso;
        this.dimensao = dimensao;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
            " peso='" + getPeso() + "'" +
            ", dimensao='" + getStringDimensao() + "'" +
            "}";
    }

    
    /** 
     * @return double
     */
    public double getPeso() {
        return this.peso;
    }

    
    /** 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    
    /** 
     * @return double[]
     */
    public double[] getDimensao() {
        return this.dimensao;
    }

    
    /** 
     * @return String
     */
    private String getStringDimensao(){
        double[] hold = getDimensao();
        String dimString = "";
        for (double d : hold) {
            dimString += String.valueOf(d) + " x ";
        }
        dimString = dimString.substring(0, dimString.length()-2);
        return dimString;
    }
    
    /** 
     * @param dimensao
     */
    public void setDimensao(double[] dimensao) {
        this.dimensao = dimensao;
    }

}
