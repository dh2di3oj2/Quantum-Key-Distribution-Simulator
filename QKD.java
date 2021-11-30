import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
public class QKD {

    public static void main(String[] args) {
/*
 *Vertical (One bit), Horizontal (Zero bit)
 * 45 degree right (One bit), or 45 degree left (Zero bit)
 */
        Queue<Integer> alice = new LinkedList<>();
        //this is alice's original key

        for (int i = 0; i < 8; i++){
            alice.add((int) Math.round(Math.random())); //adds 1 (vertical or right) or 0 (horizontal or left)
        }

//queue containing which polarizers alice used, 1 is vertical horizontal polarizer and 0 is diagonal polarizer
        Queue<Integer> ap = new LinkedList<>(); // ap is alice's polarizers

        for (int i = 0; i < 8; i++){
            ap.add((int) Math.round(Math.random())); //adds 1 or 0
        }


        System.out.println("Alice's polarizers: "+ ap);


        Queue<Integer> transfer = new LinkedList<>(); // clone of Alice's queue
        for(Integer x:alice) {
            transfer.add(x);
        }
        //System.out.println(alice);


        Queue<Integer> bd = new LinkedList<>(); // queue with what detectors Bob uses
        Queue<Integer> Bob = new LinkedList<>(); // Bob's received Key
        Queue<Integer> aliceOut = new LinkedList<>(); //Alice's edited key

        for (int i = 0; i < alice.size(); i++){
          bd.add((int) Math.round( Math.random() ));
      }
        System.out.println("\nBob's detectors (Randomized) \n 1 = vertical / horizontal 0 = diagonal:  " + bd);
    //detects transmitted queue
        for(Integer j: bd){
           // System.out.println(j);

                if((Objects.equals(ap.remove(), j))) { // detector and polarizer do match so bit is transferred
                int a = transfer.remove();
                    Bob.add(a);
                    aliceOut.add(a);

                }
                else {
                    transfer.remove();

                }
           //if detector and polarizer do not match then bit is thrown out



        }

        System.out.println("Bob's key " + Bob);
        System.out.println("Alice's key " + aliceOut);
        System.out.println("Both parties have a secure and randomized encription key");

    }
}
