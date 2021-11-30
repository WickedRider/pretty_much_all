package MarinaAlbufeira;

public class Marinha extends Barco {
    protected Boolean isFragata;
    /**
     * 
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     * @param isFragata : Boolean to decide sub type of Marinha 
     */
    public Marinha (String struct, String size, int plate, boolean isFragata){
        super(struct, size, plate);
        this.isFragata = isFragata;
    }

    
    
    public Boolean isIsFragata() {
        return this.isFragata;
    }

    
    /** 
     * @return Boolean value of isFragata
     */
    public Boolean getIsFragata() {
        return this.isFragata;
    }

    
    /** 
     * @param isFragata set value of isFragata
     */
    public void setIsFragata(Boolean isFragata) {
        this.isFragata = isFragata;
    }


    
    /** 
     * @return String of Marinha type
     */
    @Override
    public String toString() {
        if(isFragata){
        return super.toString() + "; Fragata ";
        }
        return super.toString() + "; Torpedeiro ";
    }

    
}
