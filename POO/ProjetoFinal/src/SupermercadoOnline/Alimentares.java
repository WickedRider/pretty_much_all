package SupermercadoOnline;




public class Alimentares extends Produtos{
    protected double calPerCem;
    protected double fatPercent;

    public Alimentares(double calPerCem, double fatPercent, String identificador, String nomeProd, double precoUni, int stock){
        super(identificador, nomeProd, precoUni, stock);
        this.calPerCem = calPerCem;
        this.fatPercent = fatPercent;
    }


    
    /** 
     * @return String concatenada do produto com string do produto Alimentar
     */
    @Override
    public String toString() {
        return super.toString() +
            " calPerCem='" + getCalPerCem() + "'" +
            ", fatPercent='" + getFatPercent() + "'" +
            "}";
    }

    
    /** 
     * @return double : valor de calorias por cem gramas
     */
    public double getCalPerCem() {
        return this.calPerCem;
    }

    
    /** 
     * @param calPerCem [double]: definir calorias por cem gramas
     */
    public void setCalPerCem(double calPerCem) {
        this.calPerCem = calPerCem;
    }

    
    /** 
     * @return double : valor da percentagem de gordura
     */
    public double getFatPercent() {
        return this.fatPercent;
    }

    
    /** 
     * @param fatPercent [double]: definir percentagem de gordura
     */
    public void setFatPercent(double fatPercent) {
        this.fatPercent = fatPercent;
    }

}
