package ExerciseBasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class RageExpenses11 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int lostGames=Integer.parseInt(scanner.nextLine());
        double headSetPrice=Double.parseDouble(scanner.nextLine());
        double mousePrice=Double.parseDouble(scanner.nextLine());
        double keyboardPrice=Double.parseDouble(scanner.nextLine());
        double displayPrice=Double.parseDouble(scanner.nextLine());

        int countHeadSet=lostGames/2;
        int countMouse=lostGames/3;
        int countKeyboard=lostGames/6;
        int countDisplay=lostGames/12;

        double finalSum=(countHeadSet*headSetPrice)+(mousePrice*countMouse)+(keyboardPrice*countKeyboard)+(displayPrice*countDisplay);
        System.out.printf("Rage expenses: %.2f lv.", finalSum);
    }
}
