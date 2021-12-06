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

    public void setData(Data dt){
        mcll = new Miscellaneous();
        dt.setDia(mcll.getInt("Dia: "));
        dt.setMes(mcll.getInt("Mes:"));
        dt.setAno(mcll.getInt("Ano: "));
    }

    @Override
    public String toString() {
        return "{" +
            " dia='" + getDia() + "'" +
            ", mes='" + getMes() + "'" +
            ", ano='" + getAno() + "'" +
            "}";
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return this.mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


}
