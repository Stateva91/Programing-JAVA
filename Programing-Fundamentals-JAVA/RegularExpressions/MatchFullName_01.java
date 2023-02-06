package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //"Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Georgi Georgiev, Ivan	Ivanov"
        String regex = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b"; // suhranqvame shablona
        Pattern pattern = Pattern.compile(regex); // шаблон

        Matcher matcher = pattern.matcher(text); //текстовете от променливата text, които отговарят на шаблона
        //matcher = {Ivan Ivanov, Georgi Georgiev}

        while (matcher.find()) { // dokato tozi matcher namira neshto
            System.out.print(matcher.group() + " "); // .group vzima vsichki sreshtaniq
        }
    }
}
