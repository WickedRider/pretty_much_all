package SupermercadoOnline;

import java.io.Serializable;
import java.util.ArrayList;

public class Compras implements Serializable{
    protected Cliente cl;
    ArrayList<Produtos> prod;
    public Compras(){
        cl = new Cliente();
        prod = new ArrayList<Produtos>();
    }

    @Override
    public String toString() {
        return "{" +
            " cl='" + getCl() + "'" +
            ", prod='" + getProd() + "'" +
            "}";
    }

    public Cliente getCl() {
        return this.cl;
    }

    public void setCl(String nome, String morada, String mail, long telefone, String data) {
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
