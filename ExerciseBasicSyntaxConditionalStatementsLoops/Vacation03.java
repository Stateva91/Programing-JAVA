package ExerciseBasicSyntaxConditionalStatementsLoops;


import java.util.Scanner;

public class Vacation03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();

        double singlePrice = 0;
        double totalPrice = 0.0;

        switch (group) {
            case "Students":
                if (day.equals("Friday")) {
                    singlePrice = 8.45;
                } else if (day.equals("Saturday")) {
                    singlePrice = 9.80;
                } else if (day.equals("Sunday")) {
                    singlePrice = 10.46;
                }
                break;
            case "Business":
                if (day.equals("Friday")) {
                    singlePrice = 10.90;
                } else if (day.equals("Saturday")) {
                    singlePrice = 15.60;
                } else if (day.equals("Sunday")) {
                    singlePrice = 16;
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    singlePrice = 15;
                } else if (day.equals("Saturday")) {
                    singlePrice = 20;
                } else if (day.equals("Sunday")) {
                    singlePrice = 22.50;
                }
                break;
        }
        totalPrice = singlePrice * people;

        if (people >= 10 && people <= 20 && group.equals("Regular")) {

            totalPrice = totalPrice * 0.95;

        } else if (people <= 30 && group.equals("Students")) {

            totalPrice = totalPrice * 0.85;

        } else if (people >= 100 && group.equals("Business")) {

            totalPrice = (people-10)*singlePrice;
        }
        System.out.printf("Total price: %.2f", totalPrice);
    }

}