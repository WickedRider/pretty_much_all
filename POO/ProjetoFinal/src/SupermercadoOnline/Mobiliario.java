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
     * @return String : string do produto concatenada com string caracterizante da mobilia
     */
    @Override
    public String toString() {
        return super.toString() +
            " peso='" + getPeso() + "'" +
            ", dimensao='" + getStringDimensao() + "'" +
            "}";
    }

    
    /** 
     * @return double : peso da mobilia
     */
    public double getPeso() {
        return this.peso;
    }

    
    /** 
     * @param peso [double]: definir peso da mobilia
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    
    /** 
     * @return double[] : array com dimensao da mobilia
     */
    public double[] getDimensao() {
        return this.dimensao;
    }

    /** 
     * @param dimensao [double[]] : definir dimensao da mobilia
     */
    public void setDimensao(double[] dimensao) {
        this.dimensao = dimensao;
    }
    
    /** 
     * @return String : string com dimensao da mobilia 
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
    

}
