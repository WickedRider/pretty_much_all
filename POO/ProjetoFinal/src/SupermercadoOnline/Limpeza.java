package SupermercadoOnline;


public class Limpeza extends Produtos{
    protected double gTox; // [0 - 10]
    
    public Limpeza(double gTox, String identificador, String nomeProd, double precoUni, int stock) {
        super(identificador, nomeProd, precoUni, stock);
        this.gTox = gTox;
    }


    
    /** 
     * @return String produtos concatenada com string caracterizadora de produtos Limpeza
     */
    @Override
    public String toString() {
        return super.toString() +
            " gTox='" + getGTox() + "'" +
            "}";
    }

    
    /** 
     * @return int : valor do grau de toxicidade
     */
    public double getGTox() {
        return this.gTox;
    }

    
    /** 
     * @param gTox [int]: definir grau de toxicidade do produto
     */
    public void setGTox(int gTox) {
        this.gTox = gTox;
    }

}
