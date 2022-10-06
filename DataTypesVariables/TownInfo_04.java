package DataTypesVariables;

import java.util.Scanner;

public class TownInfo_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String nameTown= scanner.nextLine();
        int population= Integer.parseInt(scanner.nextLine());
         short  area=Short.parseShort(scanner.nextLine());

         String result=String.format("Town %s has population of %d and area %d square km.", nameTown, population, area);

        System.out.println(result);

    }
}
