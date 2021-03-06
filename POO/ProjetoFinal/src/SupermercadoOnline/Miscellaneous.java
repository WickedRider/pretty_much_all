package SupermercadoOnline;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Miscellaneous implements Serializable{
    public Miscellaneous(){

    }

    
    /** 
     * Receber número inteiro de forma ocasional
     * @param k : inteiro recebido; toma um valor recebido e é retomado
     * @param state : true: print de uma mensagem caracterizante
     * @return int : valor recebido de input
     */
    public int intCheck(int k, boolean state){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                if(state)
                    System.out.println("1 -> Mostrar Produtos disponiveis. \n2 -> Comprar Produto de Mobiliario. \n3 -> Comprar Produtos de Limpeza. \n4 -> Comprar Produtos Alimentares");
                
                k = Integer.parseInt(sc.next());
                return k;
            } catch (NumberFormatException e){
                System.out.println("Input invalido. Tente Novamente.");
                intCheck(k, state);
            }
        }
        
    }


    
    /** 
     * @param message : string a dar print enquanto:
     * @return int input
     */
    public int getInt(String message){
        Scanner sc = new Scanner(System.in);
        while(true){
            try{
                System.out.println(message);
                return sc.nextInt();
            } catch (InputMismatchException e){
                sc.next();
                System.out.println("Input Invalido");
            }
        }
    }
}
