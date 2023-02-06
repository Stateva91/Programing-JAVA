package FinalExam_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text= scanner.nextLine();
        String regex="(?<symbol>[@\\|#])(?<text>[A-Za-z]{3,})\\1\\1(?<mirror>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        List<String> pairs = new ArrayList<>(); //списък с двойките
        int countAllPairs = 0; //брой на всички двойки
        while (matcher.find()){

            String first= matcher.group("text");
            String second= matcher.group("mirror");
            countAllPairs++;
            //2. проверка дали думите са печеливши
            StringBuilder secondWordBuilder = new StringBuilder(second);
            String reversedSecondWord = secondWordBuilder.reverse().toString();

            if (first.equals(reversedSecondWord)) {
                pairs.add(first + " <=> " + second);
            }
        }
        //отпечатваме брой на намерените двойки
        if (countAllPairs == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.println(countAllPairs + " word pairs found!");
        }

        // отпечатваме само валидните двойки
        if (pairs.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairs));
        }

    }
}
