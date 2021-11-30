package biblioteca;

/**
 * Represents a reader
 */

public class Reader {
    
    private int iD;
    private String rName;
    
    public Reader(){
        
    }

    public Reader(String rName, int iD){
        this.rName = rName;
        this.iD = iD;
    }
    
    
    /** 
     * @param iD : Represents the <code>reader's ID</code>
     */
    public void setiD(int iD) {
        this.iD = iD;
    }
    
    /** 
     * @return Integer with the <code>Reader's ID</code>
     */
    public int getiD() {
        return iD;
    }
    
    /** 
     * @param rName : Represents the <code>reader's Name</code>
     */
    public void setrName(String rName) {
        this.rName = rName;
    }
    
    /** 
     * @return String with the <code>reader's name</code>
     */
    public String getrName() {
        return rName;
    }

}
