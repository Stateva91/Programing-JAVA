package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class BeerKegs_08 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //входни данни: брой кегове
        //за всеки кег повтаряме:
        //1. прочитаме данните - OK
        //2. обем = π * r^2 * h - OK
        //3. проверка дали ми е най-големия кег

        //търсим максимална стойност
        //1. променлива, в която ще съхраняваме тази стойност

        double maxVolume=Double.MIN_VALUE;
        String maxModelKeg="";
        int countKegs=Integer.parseInt(scanner.nextLine());

        for (int keg = 1; keg <=countKegs ; keg++) {

            String kegModel= scanner.nextLine();
            double radius=Double.parseDouble(scanner.nextLine());
            int height=Integer.parseInt(scanner.nextLine());

            double volume= Math.PI*Math.pow(radius, 2)*height;

            //2. проверка дали дадения обем ми е по-голям от максималния

            if(volume>maxVolume) {

                maxVolume = volume;
                maxModelKeg = kegModel;
            }
        }
        System.out.println(maxModelKeg); //модела на най-големия кег
    }
}
