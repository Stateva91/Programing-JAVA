package BasicSyntaxConditionalStatementsLoops;

import java.util.Scanner;

public class TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int age= Integer.parseInt(scanner.nextLine());
        String day= scanner.nextLine();
        double price=0.0;

        boolean isValue=true;
        if(day.equals("Weekday")) {

            if (age >= 0 && age <= 18) {
                price = 12;
            } else if(age >18  && age <= 64){
              price=18;
            } else if (age >64 && age <= 122){
                price=12;
            }else
            {
                isValue=false;
            }
        } else if (day.equals("Weekend")){
            if (age >= 0 && age <= 18) {
                price = 15;
            } else if(age >18  && age <= 64){
                price=20;
            } else if (age >64 && age <= 122){
                price=15;
            }else
            {
                isValue=false;
            }

        }
        else if (day.equals("Holiday")){
            if (age >= 0 && age <= 18) {
                price = 5;
            } else if(age >18  && age <= 64){
                price=12;
            } else if (age >64 && age <= 122){
                price=10;
            }
            else
            {
                isValue=false;
            }
        }
        else
        {
            isValue=false;
        }
        if(isValue){
            System.out.println(price + "$");
        }
        else {
            System.out.println("Error!");
        }

    }
}
