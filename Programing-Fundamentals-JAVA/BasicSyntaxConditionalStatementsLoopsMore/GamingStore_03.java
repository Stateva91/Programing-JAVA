package BasicSyntaxConditionalStatementsLoopsMore;

import java.util.Scanner;

public class GamingStore_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       /*Write a program that helps you buy the games.
        The valid games are the following games in this table:
        Name	                    Price
        OutFall 4	                $39.99
        CS: OG	                    $15.99
        Zplinter Zell	            $19.99
        Honored 2	                $59.99
        RoverWatch	                $29.99
        RoverWatch Origins Edition	$39.99
        * */
        double currentBalance = Double.parseDouble(scanner.nextLine());
        double startBalance = currentBalance;
        String command = scanner.nextLine();
        String boughtGame = "";
        while (!command.equals("Game Time")) {
            // String game = command;
            if (currentBalance > 0) {
                if (!command.equals("OutFall 4") &&
                        !command.equals("CS: OG") &&
                        !command.equals("Zplinter Zell") &&
                        !command.equals("Honored 2") && !command.equals("RoverWatch") &&
                        !command.equals("RoverWatch Origins Edition")) {
                    System.out.println("Not Found");
                    command = scanner.nextLine();
                    continue;
                }
                if (command.equals("OutFall 4") && currentBalance >= 39.99) {
                    currentBalance -= 39.99;
                    boughtGame = "OutFall 4";
                    System.out.printf("Bought %s\n", boughtGame);
                } else if (command.equals("CS: OG") && currentBalance >= 15.99) {
                    currentBalance -= 15.99;
                    boughtGame = "CS: OG";
                    System.out.printf("Bought %s\n", boughtGame);
                } else if (command.equals("Zplinter Zell") && currentBalance >= 19.99) {
                    currentBalance -= 19.99;
                    boughtGame = "Zplinter Zell";
                    System.out.printf("Bought %s\n", boughtGame);
                } else if (command.equals("Honored 2") && currentBalance >= 59.99) {
                    currentBalance -= 59.99;
                    boughtGame = "Honored 2";
                    System.out.printf("Bought %s\n", boughtGame);
                } else if (command.equals("RoverWatch") && currentBalance >= 29.99) {
                    currentBalance -= 29.99;
                    boughtGame = "RoverWatch";
                    System.out.printf("Bought %s\n", boughtGame);
                } else if (command.equals("RoverWatch Origins Edition") && currentBalance >= 39.99) {
                    currentBalance -= 39.99;
                    boughtGame = "RoverWatch Origins Edition";
                    System.out.printf("Bought %s\n", boughtGame);
                } else {
                    System.out.println("Too Expensive");
                    command = scanner.nextLine();
                    continue;
                }
            }
            if (currentBalance == 0) {
                System.out.println("Out of money");
                break;
            }
            command = scanner.nextLine();
        }

         if ( currentBalance!= 0) {
                 System.out.printf("Total spent: $%.2f. Remaining: $%.2f\n", startBalance - currentBalance, currentBalance);
                 }
    }
    }


