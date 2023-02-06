package FinalExam_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String places= scanner.nextLine();

        String regex="(?<symbol>[=\\/])(?<name>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(places);
        List<String> matchedWords = new ArrayList<>();
      int travelPoints=0;
        while (matcher.find()){

            String destination= matcher.group("name");
            matchedWords.add(destination);
            travelPoints+=destination.length();


        }
        System.out.printf("Destinations: ");
        System.out.println(String.join(", ", matchedWords));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
