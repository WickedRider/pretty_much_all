package MarinaAlbufeira;

public class Barco {
    protected String struct;
    protected String size;
    protected int plate;
    
    /**
     * 
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     */
    public Barco(String struct, String size, int plate){
        this.struct = struct;
        this.size = size;
        this.plate = plate;
    }

    
    /** 
     * @return String
     */
    public String getStruct() {
        return this.struct;
    }

    
    /** 
     * @param struct
     */
    public void setStruct(String struct) {
        this.struct = struct;
    }

    
    /** 
     * @return String
     */
    public String getSize() {
        return this.size;
    }

    
    /** 
     * @param size
     */
    public void setSize(String size) {
        this.size = size;
    }

    
    /** 
     * @return int
     */
    public int getPlate() {
        return this.plate;
    }

    
    /** 
     * @param plate
     */
    public void setPlate(int plate) {
        this.plate = plate;
    }    

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " plate='" + getPlate() + "'" +
            "; struct='" + getStruct() + "'" +
            "; size='" + getSize() + "'";
    }
}
