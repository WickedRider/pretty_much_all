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
     * @return String
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
        // if(isFreq()){
        //     string += ", é um cliente frequente.";
        // } else {
        //     string += ", é um cliente regular.";
        // }
        return string;
    }   
    

    public Boolean isFreq() {
        return this.freq;
    }

    public Boolean getFreq() {
        return this.freq;
    }

    public void setFreq(Boolean freq) {
        this.freq = freq;
    }

    public ArrayList<Compras> getCmp() {
        return this.cmp;
    }

    public void setCmp(ArrayList<Compras> cmp) {
        this.cmp = cmp;
    }

    /**
     * @return String
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return String
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * @return String
     */
    public String getMail() {
        return this.mail;
    }

    /**
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return long
     */
    public long getTelefone() {
        return this.telefone;
    }

    /**
     * @param telefone
     */
    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    /**
     * @return String
     */
    public String getData() {
        return this.data;
    }

    /**
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

}
