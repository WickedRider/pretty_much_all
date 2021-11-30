package exercicioAV;

import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        int key = 0; 
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Selecione uma das seguintes opcoes:\n1->Desenho em colunas do numero inserido\n2->Numero de ocorrencias de um algarismo, recebido, nesse numero");
        key = sc.nextInt();
        menu(key);
        

        sc.close();
    }
//  CHECK FOR POSITIVITY OF INPUT
    private static int checkPos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um valor positivo: ");
        int n = sc.nextInt();
    
        sc.close();
        
        if(n <= 0) {
            return -n;
        }
        
        return n;
    }

    private static void menu(int key) {
        Scanner sc = new Scanner(System.in);
        ocurr oc = new ocurr();
        draw dw = new draw();
        int num = 0;
        switch (key) {
            case 1:
                num = checkPos();
                if(repeatedAlg(String.valueOf(num))){
                    dw.drawing(num);
                }
                else{
                    System.out.println("Numero com algarismos repetidos.");
                }
                break;
            case 2:  
                System.out.println("Insira um algarismo: ");   
                int alg = sc.nextInt();
                //  CONTROLLING CONDITIONAL
                if(alg < 0 || alg > 9) {
                    break;
                }
                num = checkPos();
                oc.ocorrencias(num, alg);
                System.out.println("\nO algarismo repete-se " + oc.ocorrencias(num, alg) + " vezes, no numero inserido.\n");
                break;
            default:
                System.out.println("INVALID OPTION.");
                break;
        }
        sc.close();
    }

    private static boolean repeatedAlg(String str) {

        for (int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(i != j){
                    if(str.charAt(i) == str.charAt(j)){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
//  nextInt DOES NOT CONSUME \n IN INPUT, SO nextline TAKES IT
 



}
