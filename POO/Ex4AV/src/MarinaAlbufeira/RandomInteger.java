package MarinaAlbufeira;

public class RandomInteger {
    
    /** 
     * 
     * @param min : lower limit [INCLUSIVE]
     * @param max : upper limit [INCLUSIVE]
     * @return int : random integer between min and max
     */
    public int randinteger(int min, int max){
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
