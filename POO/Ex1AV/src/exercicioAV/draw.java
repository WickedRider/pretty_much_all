package exercicioAV;

public class draw {
    public void drawing(int num){
        String str = String.valueOf(num);
        int colunas = str.length();
        int linhas = lines(num, str);
        char a = ' ';
        String hold = "";
        for(int i = linhas; i > 0; i--) {
            for(int j = 0; j < colunas; j++) {
                a = str.charAt(j);
                if(Character.getNumericValue(a) >= linhas) {
                    hold +=  "*";
                }
                else {
                    hold += " ";
                }
                hold += " ";
            }
            linhas--;
            System.out.println(hold);
            hold = "";
        }
        for (int n = 0; n < colunas; n++) {
            System.out.print(str.charAt(n) + " ");
        }
        System.out.println();

    }

    private int lines(int num, String str) {
        int ln = 0, c;
        
        for(int n = 0; n < str.length();n++){
            c = Character.getNumericValue(str.charAt(n));
            if(c > ln){
                ln = c;
            }
        }
        System.out.println(ln);
        return ln;
    }
    
}
