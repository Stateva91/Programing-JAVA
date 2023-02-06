package FinalExam_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regexEmoji ="([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})(\\1)";
        Pattern pattern = Pattern.compile(regexEmoji);
        Matcher matcher=pattern.matcher(text);

        int coolSum = 1;

        for (char symbol:text.toCharArray()) {
            if(Character.isDigit(symbol)) {
                coolSum *= Integer.parseInt(symbol + "");
            }// symbol+ ""-> pravq simvola na tekst
        }
        System.out.printf("Cool threshold: %d%n", coolSum);
        int count = 0;
        List<String> coolEmoji = new ArrayList<>();

        while (matcher.find()) {
            count++;
            int emojiSum = 0;
            String emoji = matcher.group("emoji");

            for (char symbol : emoji.toCharArray()) {

                emojiSum += (int) symbol;
            }
            if (emojiSum >= coolSum) {

                coolEmoji.add(matcher.group());
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        coolEmoji.forEach(emoji -> System.out.println(emoji));
    }
}
