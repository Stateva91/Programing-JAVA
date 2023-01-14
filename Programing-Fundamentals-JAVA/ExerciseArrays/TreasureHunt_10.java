package ExerciseArrays;

import java.util.Scanner;

public class TreasureHunt_10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String [] treasureChest=scanner.nextLine().split("\\|");

        String command=scanner.nextLine();

        while (!command.equals("Yohoho!")){



            command= scanner.nextLine();
        }

    }
}
