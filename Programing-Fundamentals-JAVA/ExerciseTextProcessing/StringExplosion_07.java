package ExerciseTextProcessing;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder textBuilder = new StringBuilder(input);
        int totalPower = 0;
        for (int i = 0; i < textBuilder.length(); i++) {
            char symbol = textBuilder.charAt(i);
            if (symbol == '>'){
                int power = Integer.parseInt(textBuilder.charAt(i + 1) + "");
                totalPower += power;
            } else if (symbol != '>' && totalPower > 0) {
                textBuilder.deleteCharAt(i);
                totalPower--;
                i--;
            }
        }
        System.out.println(textBuilder);
    }
}
