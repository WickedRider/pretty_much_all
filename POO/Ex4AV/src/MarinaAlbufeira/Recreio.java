package MarinaAlbufeira;

public class Recreio extends Barco {
    protected int nPass;
    
    /**
     * 
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     * @param nPass : Number of passengers
     */
    public Recreio(String struct, String size, int plate, int nPass){
        super(struct, size, plate);
        this.nPass = nPass;
    }
    
    /** 
     * @return Number of passangers
     */
    public int getNPass() {
        return this.nPass;
    }

    
    /** 
     * @param nPass : Number of passengers
     */
    public void setNPass(int nPass) {
        this.nPass = nPass;
    }

    
    /** 
     * @return Number of passengers as String
     */
    @Override
    public String toString() {
        return super.toString() +
            "; Numero de Passageiros: '" + getNPass() + "'" +
            "}";
    }

    
    


}
