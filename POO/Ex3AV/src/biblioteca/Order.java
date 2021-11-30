package biblioteca;

public class Order {
    // CONSTRUCTORS
    Book bk = new Book();
    Reader rd = new Reader();
    Date dt = new Date();
    Date dtt = new Date();
    //  
    // GLOBAL VARIABLES
    /**
     * 2D String array composed of all books
     */
    String[][] allBooks = new String[2][4];
    /**
     * 2D String array composed of all readers information
     */
    String[][] allReaders = new String[2][];
    
    // FUNCTIONS
    
    public Order(Reader r, Book b, Date dO, Date dR){
        this.rd = r;
        this.bk = b;
        this.dt = dO;
        this.dtt = dR;
    }

    public Order(){

    }


    /**
     * Predefined data to run experiments
     */
    public void setup() {
        //      READERs
        Reader rd1 = new Reader("name", 1002);
        Reader rd2 = new Reader("name1", 1052);
        String[] reader1 = {rd1.getrName(), String.valueOf(rd1.getiD())};
        String[] reader2 = {rd2.getrName(), String.valueOf(rd2.getiD())}; 
        allReaders[0] = reader1; allReaders[1] = reader2;
        //      BOOKs
        Book bk1 = new Book("title", "aNam");
        Book bk2 = new Book("tittle", "aNamee");
        String[] book1 = {bk1.getTitle(), bk1.getaName(), "-", "-"};
        String[] book2 = {bk2.getTitle(), bk2.getaName(), "-", "-"};
        allBooks[0] = book1; allBooks[1] = book2;
        
    }

    
    /** 
     * Show all available books
     * @param aBooks : 2D array that contains all the books
     */
    public void listAvailableBooks(){
        System.out.println("\nAvailable Books: ");
        for (String[] strings : allBooks) {
            if(strings[2] == "-" || strings[3] == "-"){
                System.out.println("-> " + strings[0] + ", wrote by " + strings[1]);
            }
            
        }
        
    }
    
    
    /** 
     * Show books that are ordered at the inputed date
     * @param dChoice : date of choice
     */
    public void listOrdered(Date dChoice){
        System.out.println("\nBooks ordered at " + dChoice.getDate() + ":");
        String hold = dChoice.getDate();
        int day = Integer.parseInt(hold.substring(0, 2));
        int month = Integer.parseInt(hold.substring(3, 5));
        int year = Integer.parseInt(hold.substring(6, 10));
        for (String[] strings : allBooks) {
            if(strings[2] == "-")
                continue;
            else
                if(day == Integer.parseInt(strings[2].substring(0,2)) && (month == Integer.parseInt(strings[2].substring(3,5))) && (year == Integer.parseInt(strings[2].substring(6,10))) ){
                    System.out.println(strings[0] + " , " + strings[1]);
            }
            
        }
    }

    /** 
     * @param r : Reader
     * @param dtOrder : Date of order
     * @param dtReturn : Date of returnal
     * @return Order "receipt"
     */
    public Order orderBook(Reader r, Book bo, Date dtOrder, Date dtReturn){
        Order od = new Order(r, bo , dtOrder, dtReturn);
        int i = 0;
        if(dt.dateViability(dtOrder, dtReturn)){
            for (String[] strings : allBooks) {
                if (strings[0] == bo.getTitle() && strings[1] == bo.getaName()){
                    allBooks[i][2] = dtOrder.getDate();
                    allBooks[i][3] = dtReturn.getDate();
                    break;
                }
                i++;
            }
        }else{
            System.exit(0);
        }
        

        return od;
    }

    
    
}
