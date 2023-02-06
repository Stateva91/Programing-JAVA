package FinalExam_01;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text= scanner.nextLine();
        String regex="(?<symbol>[#\\|])(?<name>[A-Za-z\\s]+)(\\1)(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int totalCalories=0;

        StringBuilder output=new StringBuilder();

        while (matcher.find()){


            String food= matcher.group("name");
            String date= matcher.group("date");
            int calories= Integer.parseInt(matcher.group("calories"));

            totalCalories+=calories;

            output.append(String.format("Item: %s, Best before: %s, Nutrition: %d%n", food, date, calories));


        }
        int day=totalCalories/2000;
        System.out.printf("You have food to last you for: %d days!%n", day);
        System.out.println(output);


    }
}
