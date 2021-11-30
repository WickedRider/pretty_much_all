package MarinaAlbufeira;

public class Torpedeiro extends Marinha{
    protected int nTorperdos;
    public Torpedeiro(String struct, String size, int plate, boolean isFragata ,int nTorperdos){
        super(struct, size, plate, isFragata);
        this.nTorperdos = nTorperdos;
    }
    
    
    /** 
     * @return Number of torpedos
     */
    public int getNTorperdos() {
        return this.nTorperdos;
    }
    
    
    /** 
     * @param nTorperdos set number of torpedos
     */
    public void setNTorperdos(int nTorperdos) {
        this.nTorperdos = nTorperdos;
    }
    
    
    /** 
     * @return String with number of torpedos
     */
    @Override
    public String toString() {
        return super.toString() +
        "com '" + getNTorperdos() + "' Torpedos" + "}";
    }
    
}