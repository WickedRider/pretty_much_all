package ex2avaliacao;
/*
Faça um programa que crie uma tabela de números inteiros de tamanho N> 2.
O tamanhoda tabela e os respetivos elementos são solicitados ao utilizador.
Caso o tamanhofornecido seja inválido,o programatermina a execução.
O programa deve prosseguir com a procura de uma sub-tabelada tabela original com a sequência de
elementos desta que devem ser ordenados, por ordem crescente, 
para que toda a tabela fique ordenada,também por ordem crescente. 
No final, deve imprimir a sub-tabela(não ordenada)que cumpriu a condição.
Tabela = {1, 2, 3, 0, 4, 6}     Sub-tabela:{1, 2, 3, 0}
Tabela = {1, 3, 2, 7, 5, 6, 4, 8}       Sub-tabela:{3,2,7,5,6,4}
Tabela = {3, 2, 7, 5, 6, 4, 1}      Sub-tabela:{3, 2, 7, 5, 6, 4, 1}
*/

public class App{
    public static void main(String[] args) throws Exception {
        GetInteiro gI = new GetInteiro();
        int n = gI.getInt("Enter a positive number for array lenght: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = gI.getInt("Enter values for the array");
        }
        checkOrder1(arr);


    }
    
    public static void checkOrder1(int[] ar) {
        int[] outOfOrder = new int[ar.length];
        boolean check = false;
        int track=0,ind=0,k=0;


        while (track < ar.length) {
            while(k<ar.length) {
                if(k<=track){
                    if(ar[track]<ar[k]){
                        check = true;
                        break;
                    }
                }else{
                    if(ar[track]>ar[k]){
                        check=true;
                        break;
                    }
                }
                k++;
            }
            if(check){
                outOfOrder[ind] = ar[track];ind++;
                check=false;
                
            }
            track++;
            k = 0;
            
        }
        System.out.print("Sub-tabela:{");
        for (int i = 0; i < ind; i++) {
            if(i<ind-1){
                System.out.print(outOfOrder[i]+", ");
            } else {
                System.out.println(outOfOrder[i]+"}");
            }
        }
        System.out.println();

    }

}