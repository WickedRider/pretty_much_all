package ex2avaliacao;
import java.util.*;

public class GetInteiro{
    public int getInt(String message){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(message);
            try{
                return sc.nextInt();
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("Apenas sao aceites numeros inteiros positivos. Tente novamente: ");
            }
        }
    }
}
