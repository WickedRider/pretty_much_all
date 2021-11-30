package MarinaAlbufeira;

public class Pesca extends Barco {
    protected boolean isCana;

    
    /**
     * 
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     * @param cana : Boolean value, True: Boat with fishing rods; False: Boat with fishing nets
     */
    public Pesca(String struct, String size, int plate, boolean isCana){
        super(struct, size, plate);
        this.isCana = isCana;
    }

    

    public boolean isisCana() {
        return this.isCana;
    }

    
    /** 
     * @return value of cana
     */
    public boolean getisCana() {
        return this.isCana;
    }

    
    /** 
     * @param isCana : 
     */
    public void setisCana(boolean isCana) {
        this.isCana = isCana;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        if(isisCana()){
            return super.toString() +
                "; Pesca de cana " + "}";
        }
        return super.toString() +
                "; Pesca de rede " + "}";
    }

}
