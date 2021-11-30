package exercicioAV;

public class ocurr {
    public int ocorrencias(int num, int alg){
        int ocurr = 0;
        String str = String.valueOf(num);
        String chr = String.valueOf(alg);

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == chr.charAt(0)) {
                ocurr++;
            }
        }
        return ocurr;
    }
}
