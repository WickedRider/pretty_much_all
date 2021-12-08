package SupermercadoOnline;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {
    protected String nome;
    protected String morada;
    protected String mail;
    protected long telefone;
    protected String data;
    ArrayList<Compras> cmp;
    protected Boolean freq;

    public Cliente(String nome, String morada, String mail, long telefone, String data, ArrayList<Compras> cmp, Boolean freq) {
        this.nome = nome;
        this.morada = morada;
        this.mail = mail;
        this.telefone = telefone;
        this.data = data;
        this.cmp = cmp;
        this.freq = freq;
    }

    public Cliente() {

    }

    /**
     * @return String com informacao do cliente
     */

    @Override
    public String toString() {
        String string = "{" +
            " nome='" + getNome() + "'" +
            ", morada='" + getMorada() + "'" +
            ", mail='" + getMail() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", data='" + getData() + "' ";
        for (Compras c : getCmp()) {
            string = string + c.toString();
        }
        if(isFreq()){
            string += ", é um cliente frequente.";
        } else {
            string += ", é um cliente regular.";
        }
        return string;
    }   
    

    
    /** 
     * @return Boolean
     */
    public Boolean isFreq() {
        return this.freq;
    }

    
    /** 
     * @return Boolean : true= frequente; false= regular
     */
    public Boolean getFreq() {
        return this.freq;
    }

    
    /** 
     * @param freq [Boolean]: definir como frequente ou nao
     */
    public void setFreq(Boolean freq) {
        this.freq = freq;
    }

    
    /** 
     * @return ArrayList<Compras> : array com Compras 
     */
    public ArrayList<Compras> getCmp() {
        return this.cmp;
    }

    
    /** 
     * @param cmp [ArrayList< Compras >]: definir array com Compras
     */
    public void setCmp(ArrayList<Compras> cmp) {
        this.cmp = cmp;
    }

    /**
     * @return String : nome do cliente
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome [String]: definir nome do cliente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String : morada do cliente
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * @param morada [String]: definir morada do cliente
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return String : email do cliente
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * @param mail [String]: definir email do cliente
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return long : numero de telemovel do cliente
     */
    public long getTelefone() {
        return this.telefone;
    }

    /**
     * @param telefone [long]: definir numero de telemovel
     */
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    /**
     * @return String : data de nascimento
     */
    public String getData() {
        return this.data;
    }

    /**
     * @param data [String]: definir data de nascimento
     */
    public void setData(String data) {
        this.data = data;
    }

}
