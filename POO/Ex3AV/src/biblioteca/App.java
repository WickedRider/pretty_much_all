package biblioteca;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        App a = new App();
        a.start();
    }

    private void start(){
        Scanner sc = new Scanner(System.in);
        

        GetInput gI = new GetInput();
        MenuDecider mDc = new MenuDecider();


        int option = 0;
        Boolean n = true;
        String message = "What option would you like to choose:\n1-> Show all ordered books in the desired date.\n2-> Show all available books.\n3-> Order a book\n4-> Exit.\n";
        System.out.println("Welcome to the Library");

        
        
        while(true){
            System.out.println(message);
            option = gI.getInt("\n\nOnly the options shown are available, please enter one of them.\n" + message);
            switch (option) {
                case 1:
                //  WITH AN INPUTED DATE, SHOW ALL ORDERED BOOKS FOR THAT DATE
                    mDc.opt1();
                break;
                
                case 2:
                //  SHOW ALL AVAILABLE BOOKS
                    mDc.opt2();
                    break;

                case 3:
                //  ORDER A BOOK
                    mDc.opt3();
                    break;

                case 4:
                //  EXIT
                    System.out.println("\nProgram will now close.");n=false;
                    break;

                default:
                //  INVALID
                    System.out.println("\nInvalid option, program will now exit");
                    n = false;
                    break;
            }
            if(!n){
                sc.close();
                System.exit(0);
            }
        }
    }
}
