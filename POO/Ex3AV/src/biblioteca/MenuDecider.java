package biblioteca;


public class MenuDecider {
    GetInput gI = new GetInput();
    Order od = new Order();
    Date dt = new Date();
    Reader rd = new Reader();
    
    private boolean proceed = true;
    /**
     * Function for the first option of the menu<p>
     * Show books ordered at a given date
     */
    public void opt1(){
        String message1 = " date in the following format: dd/mm/yyyy\nie: 01/01/0001";
        System.out.println("Enter the order"+message1);
        String[] hold = gI.getString();
        Date dt = new Date(hold);
        od.listOrdered(dt);
    }
    /**
     * Function for second option of the menu<p>
     * Show all available books
     */
    public void opt2(){
        if(proceed){
            System.out.println("HERE");
            od.setup();
        }
        od.listAvailableBooks();
    }
    
    /**
     * Function for third option of the menu<p>
     * Order a book
     */
    public void opt3(){
        proceed = false;
        String message1 = " date in the following format: dd/mm/yyyy\nie: 01/01/0001";

        System.out.println("Enter the order"+message1);
        String[] hold = gI.getString();
        System.out.println("\nEnter the return"+message1);
        String[] hold2 = gI.getString();

        od.setup();

        Date dto = new Date(hold);
        Date dtr = new Date(hold2);
        Reader r = new Reader(od.allReaders[1][0], Integer.parseInt(od.allReaders[1][1]));
        Book bo = new Book(od.allBooks[0][0], od.allBooks[0][1]);
        Order s = od.orderBook(r, bo, dto, dtr);
        System.out.println(s.rd.getrName()+" with the ID: " + String.valueOf(r.getiD()) + " ordered \"" + bo.getTitle() + "\" by " + bo.getaName() + " from " + dto.getDate() + " to " + dtr.getDate());
    }
}
