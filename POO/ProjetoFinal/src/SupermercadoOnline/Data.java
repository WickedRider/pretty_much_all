package SupermercadoOnline;

public class Data {
    protected int dia;
    protected int mes;
    protected int ano;
    Miscellaneous mcll;
    public Data(){    }
    
    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    
    /** 
     * @param dt : definir data corrente
     */
    public void setData(Data dt){
        mcll = new Miscellaneous();
        dt.setDia(mcll.getInt("Dia: "));
        dt.setMes(mcll.getInt("Mes:"));
        dt.setAno(mcll.getInt("Ano: "));
    }

    
    /** 
     * @return String da data
     */
    @Override
    public String toString() {
        return "{" +
            " dia='" + getDia() + "'" +
            ", mes='" + getMes() + "'" +
            ", ano='" + getAno() + "'" +
            "}";
    }

    
    /** 
     * @return int : dia
     */
    public int getDia() {
        return this.dia;
    }

    
    /** 
     * @param dia [int]: definir dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    
    /** 
     * @return int : mes
     */
    public int getMes() {
        return this.mes;
    }

    
    /** 
     * @param mes [int]: definir mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    
    /** 
     * @return int : ano
     */
    public int getAno() {
        return this.ano;
    }

    
    /** 
     * @param ano [int]: definir ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }


}
