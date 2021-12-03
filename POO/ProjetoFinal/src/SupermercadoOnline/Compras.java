package SupermercadoOnline;

import java.io.Serializable;
import java.util.ArrayList;

public class Compras implements Serializable{
    protected Cliente cl;
    ArrayList<Produtos> prod;
    public Compras(Cliente cl, ArrayList<Produtos> prod){
        cl = new Cliente();
        prod = new ArrayList<Produtos>();
    }
    public Compras(){
        
    }

    @Override
    public String toString() {
        return "{" +
            " cl='" + getCl().toString() + "'" +
            ", prod='" + getProd() + "'" +
            "}";
    }

    public Cliente getCl() {
        return this.cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    }

    public void setCl1(String nome, String morada, String mail, long telefone, String data) {
        cl.setNome(nome);
        cl.setMorada(morada);
        cl.setMail(mail);
        cl.setTelefone(telefone);
        cl.setData(data);
    }

    public ArrayList<Produtos> getProd() {
        return this.prod;
    }

    public void setProd(ArrayList<Produtos> prod) {
        this.prod = prod;
    }

}
