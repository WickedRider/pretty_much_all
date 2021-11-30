package biblioteca;



/**
 * Represents either:<p>
 * -> <code>Request date</code><p>
 * -> <code>Return date</code>
 */
public class Date {
    
    private String[] date;

    public Date(){

    }
    
    public Date(String[] date){
        this.date = date;
    }
    
    
    public void setDate(String[] date) { 
        this.date = date;
    }
    
    /** 
     * @return String with the return date
     */
    public String getDate() {
        return (date[0]+"/"+date[1]+"/"+date[2]);
    }
    private String[] getDate1(){
        return date;
    }

    public boolean dateViability(Date ord, Date ret){
        int dayO = Integer.parseInt(ord.getDate1()[0]);
        int monthO = Integer.parseInt(ord.getDate1()[1]);
        int yearO = Integer.parseInt(ord.getDate1()[2]);
        int dayR = Integer.parseInt(ret.getDate1()[0]);
        int monthR = Integer.parseInt(ret.getDate1()[1]);
        int yearR = Integer.parseInt(ret.getDate1()[2]);
        if(dayR<dayO && monthR<monthO || monthR<monthO || yearR<yearO){
            return false;
        }
        return true;
    }
}
