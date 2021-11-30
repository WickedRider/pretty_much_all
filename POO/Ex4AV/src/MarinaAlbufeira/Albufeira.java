package MarinaAlbufeira;

import java.util.ArrayList;
import java.util.Random;

public class Albufeira {
    Random r = new Random();
    RandomInteger rI = new RandomInteger();

    private ArrayList<Barco> marina = new ArrayList<>();
       
    
    
    public static void main(String[] args) throws Exception {
        Albufeira a = new Albufeira();
        a.start();
    }
    
    public void start(){
        createBarco();
        
        for (Barco i : marina) {
            System.out.println(i.toString());
        }

        //marina.add(INT), marina.remove(INDEX), marina.sort(), marina.clear, marina.set(INDEX, INT), marina.size()
        //marina.get(INDEX)
    }
    
    private void createBarco(){
        String[] structAsize = {"Rigido", "Semirrigido", "Pequeno", "Medio", "Grande"};
        for (int i = 0; i < 10; i++) {
            int choice = rI.randinteger(1, 3);
            String struct = structAsize[rI.randinteger(0, 1)];
            String size = structAsize[rI.randinteger(2, 4)];
            int plate = i; // sequential plating
            switch (choice) {
                case 1:
                    opt1(struct, size, plate);
                    break;
                case 2:
                    opt2(struct, size, plate);
                    break;
                case 3:
                    opt3(struct, size, plate);
                    break;
                default:
                    break;
            }
        }
    }

    
    /** 
     * Criar barco de recreio
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     */
    private void opt1(String struct, String size, int plate){
        int nPass = rI.randinteger(1, 10);
        Recreio rec = new Recreio(struct, size, plate+1, nPass);
        marina.add(rec);
    }
    
    /** 
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     */
    private void opt2(String struct, String size, int plate){
        Boolean isCana = r.nextBoolean();
        Pesca pec = new Pesca(struct, size, plate+1, isCana);
        marina.add(pec);
    }
    
    /** 
     * @param struct : Structure, Rigid or Semirigid
     * @param size : Size, Small, Medium, Big
     * @param plate : Number of plates
     */
    private void opt3(String struct, String size, int plate) {
        Boolean isFragata = r.nextBoolean();
        if(isFragata){
            Boolean antiaerea = r.nextBoolean();
            Fragata frag = new Fragata(struct, size, plate+1, isFragata, antiaerea);
            marina.add(frag);
        } else {
            int nTorperdos = rI.randinteger(1, 6);
            Torpedeiro torp = new Torpedeiro(struct, size, plate, isFragata, nTorperdos);
            marina.add(torp);
        }
    }   
    
}
