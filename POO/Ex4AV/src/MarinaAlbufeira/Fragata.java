package MarinaAlbufeira;

public class Fragata extends Marinha{
    protected boolean antiaerea;
    public Fragata(String struct, String size, int plate, boolean isFragata, boolean antiaerea){
        super(struct, size, plate, isFragata);
        this.antiaerea = antiaerea;
    }
    
    
    
    public boolean isAntiaerea() {
        return this.antiaerea;
    }
    
    
    /** 
     * @return boolean value of Fragata sub type
     */
    public boolean getAntiaerea() {
        return this.antiaerea;
    }
    
    
    /** 
     * @param antiaerea set boolean value of Fragata sub type
     */
    public void setAntiarea(boolean antiaerea) {
        this.antiaerea = antiaerea;
    }

    
    /** 
     * @return String referef to boolean value of Fragata sub type
     */
    @Override
    public String toString() {
        if(isAntiaerea()){
            return super.toString() +
            "antiaerea " +
            "}";
        }
        return super.toString() + "antissubmarinas " + "}";
    }
    
    
}