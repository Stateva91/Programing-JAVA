package Methods;

import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String  products= scanner.nextLine();
        int quantity=Integer.parseInt(scanner.nextLine());
        switch (products){

            case "coffee":
                calculates(quantity, 1.50);
                break;
            case "water":
                calculates(quantity, 1.00);
                break;
            case "coke":
                calculates(quantity, 1.40);
                break;
            case "snacks":
                calculates(quantity, 2.0);
                break;


        }

    }

    public static void calculates (int quantity, double price ){

        double result=price*quantity;
        System.out.printf("%.2f", result);

    }
}
