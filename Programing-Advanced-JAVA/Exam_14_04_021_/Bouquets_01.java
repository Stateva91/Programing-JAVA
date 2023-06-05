package Exam_14_04_021_;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         String tulipsInput= scanner.nextLine();
         String daffodilInput= scanner.nextLine();

         //laleta-stek
        ArrayDeque<Integer> tulips=new ArrayDeque<>();
        //narcisi-opashka
        ArrayDeque<Integer> daffodils=new ArrayDeque<>();
        //pulnim stekas laleta
        Arrays.stream(tulipsInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(tulips::push);
        // pulnim opashka s narcisi
        Arrays.stream(daffodilInput.split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(daffodils::offer);

        int bouquets=0; // broi buketi
        int leftFlowers=0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()){
            int tulip=tulips.peek(); // vijda koi e posledniq
            int daffodil=daffodils.peek(); // vijda koi e purviq

            int sum=tulip+daffodil;
            if(sum==15){
                //pravq buket
                bouquets++;
                tulips.pop(); // premahva posledniq dobaven v steka
                daffodils.poll(); // premahva purviq element dobaven v opashkata
            } else if (sum>15){
                tulips.pop();
                tulips.push(tulip-2);
            } else if (sum<15){
               // suhranqvame sumata za po kusno
                leftFlowers+=sum;
                tulips.pop(); // premahva posledniq dobaven v steka
                daffodils.poll();
            }
        }
        //kogato svarshat buketite: broi buketi i broi na svetqtq koito ne sa obrazuvali buket
        int bouquetsLeftFlowers=leftFlowers/15;
        bouquets+=bouquetsLeftFlowers;
        if (bouquets>=5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5-bouquets);
        }
    }
}
