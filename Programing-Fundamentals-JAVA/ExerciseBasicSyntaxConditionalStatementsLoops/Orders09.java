package ExerciseBasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class Orders09 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int orders=Integer.parseInt(scanner.nextLine());

        double priceCapsule=0;
        int days=0;
        int capsulesCount=0;
        double sum=0;

        double orderPrice=0;

        for (int i = 0; i < orders; i++) {

            priceCapsule=Double.parseDouble(scanner.nextLine());
             days=Integer.parseInt(scanner.nextLine());
             capsulesCount=Integer.parseInt(scanner.nextLine());
            orderPrice=(days*capsulesCount)*priceCapsule;

            System.out.printf("The price for the coffee is: $%.2f%n", orderPrice);
            sum=sum+orderPrice;
        }

        System.out.printf("Total: $%.2f", sum);

    }
}
