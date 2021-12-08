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
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() +
            " calPerCem='" + getCalPerCem() + "'" +
            ", fatPercent='" + getFatPercent() + "'" +
            "}";
    }

    
    /** 
     * @return double
     */
    public double getCalPerCem() {
        return this.calPerCem;
    }

    
    /** 
     * @param calPerCem
     */
    public void setCalPerCem(double calPerCem) {
        this.calPerCem = calPerCem;
    }

    
    /** 
     * @return double
     */
    public double getFatPercent() {
        return this.fatPercent;
    }

    
    /** 
     * @param fatPercent
     */
    public void setFatPercent(double fatPercent) {
        this.fatPercent = fatPercent;
    }

}
