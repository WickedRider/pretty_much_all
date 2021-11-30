package biblioteca;
import java.util.*;

public class GetInput{

    
    /** 
     * @param message :  This String will be displayed if the input missmatches <code>int</code> type
     * @return Integer input
     */
    public int getInt(String message){
        int n1 = 0;
        boolean bError = true;
        while (bError) {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()){
                n1 = scanner.nextInt();
            }
            else {
                scanner.next();
                System.out.println(message);
                continue;
            }
            bError = false;
        }
        return n1;
    }

    
    /** 
     * @return String with the correct format for the date
     */
    public String[] getString(){
        String n1 = "";
        String[] n2 = new String[3];
        
        Scanner sc = new Scanner(System.in);

        n1 = sc.nextLine();
        if(proceedString(n1)){
            n2[0] = n1.substring(0, 2);
            n2[1] = n1.substring(3, 5);
            n2[2] = n1.substring(6, 10);
        } else {
            System.out.println("INVALID DATE FORMAT.\nPROGRAM WILL NOW CLOSE.");
            sc.close();
            System.exit(0);
        }

        return n2;
    }

    
    /** 
     * @param toCheck : String to hold input
     * @return <code>True</code> if the format is correct
     */
    private boolean proceedString(String toCheck){
        if(toCheck.length()<10){
            System.out.println("HAFE");
            return false;
        }
        else if (toCheck.charAt(2) != '/' || toCheck.charAt(5) != '/')
            return false;


        int day = Integer.parseInt(toCheck.substring(0, 2));
        int month = Integer.parseInt(toCheck.substring(3, 5));
        int year = Integer.parseInt(toCheck.substring(6, 10));

        
        if(day > 31 || month > 12 || year < 0)
            return false;
    
        if(month == 2 && month >= 29)
            return false;
        //  months with 30 days
        if(month % 2 == 0 && month != 2 && day == 31)
            return false;


        return true;
    }
}

