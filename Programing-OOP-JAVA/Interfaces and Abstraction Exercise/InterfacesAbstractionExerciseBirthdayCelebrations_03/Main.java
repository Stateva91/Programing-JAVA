package InterfacesAbstractionExerciseBirthdayCelebrations_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> livingBeings = new ArrayList<>();
        String info = scanner.nextLine();

        while (!info.equals("End")) {
            String[] splittedInfo = info.split(" ");

            switch (splittedInfo[0]) {
                case "Citizen":
                    livingBeings.add(new Citizen(splittedInfo[1],
                            Integer.parseInt(splittedInfo[2]),
                            splittedInfo[3],
                            splittedInfo[4]));
                    break;
                case "Pet":
                    livingBeings.add(new Pet(splittedInfo[1],
                            splittedInfo[2]));
                    break;
            }

            info = scanner.nextLine();
        }
        String year = scanner.nextLine();
        livingBeings.stream()
                .map(Birthable::getBirthDate)
                .filter(birthDate -> birthDate.endsWith(year))
                .forEach(System.out::println);

        scanner.close();
    }
}
