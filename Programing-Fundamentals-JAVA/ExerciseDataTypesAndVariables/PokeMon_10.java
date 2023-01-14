package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class PokeMon_10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни -> power, distance, factor
        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int factor = Integer.parseInt(scanner.nextLine());
        //повтаряме:
        //1. power -= distance -> бр. poke++
        //2. проверка за умората
        //stop: power < distance
        //продължава: power >= distance
        int firstPower = power; //първоначално въведената сила
        int countPoke = 0;
        while (power >= distance) {
            //отива до целта -> хаби енергия
            power -= distance;
            //стига -> poke-ване
            countPoke++;

            //проверка дали не е изморен
            if (power == firstPower / 2) {
                if (factor != 0) {
                    //позволена аритметична операция деление
                    power = power / factor;
                }
            }
        }

        System.out.println(power); //текуща сила
        System.out.println(countPoke); //брой на успешни poke-вания

    }
}
