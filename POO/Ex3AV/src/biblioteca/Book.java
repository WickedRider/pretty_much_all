package biblioteca;
/**
 * Represents the book's components for request
 */
public class Book {
    
    private String title;
    private String aName;

    public Book(){

    }

    public Book(String title, String aName){
        this.title = title;
        this.aName = aName;
    }

    
    /** 
     * @param title Represents the book's title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /** 
     * @return String with the book's Title
     */
    public String getTitle() {
        return title;
    }
    
    /** 
     * @param aName Represents the name of Author
     */
    public void setaName(String aName) {
        this.aName = aName;
    }
    
    /** 
     * @return String with the author's name
     */
    public String getaName() {
        return aName;
    }

}
