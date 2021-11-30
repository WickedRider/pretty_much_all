package SupermercadoOnline;


public class Limpeza extends Produtos{
    protected double gTox; // [0 - 10]
    
    public Limpeza(double gTox, String identificador, String nomeProd, double precoUni, int stock) {
        super(identificador, nomeProd, precoUni, stock);
        this.gTox = gTox;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
            " gTox='" + getGTox() + "'" +
            "}";
    }

    
    /** 
     * @return int
     */
    public double getGTox() {
        return this.gTox;
    }

    
    /** 
     * @param gTox
     */
    public void setGTox(int gTox) {
        this.gTox = gTox;
    }

}
