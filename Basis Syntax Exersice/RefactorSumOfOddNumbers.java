package Upr5;

import java.util.Scanner;

public class RefactorSumOfOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int sum = 1;
        int counter=0;

        for (int i = 0; i < n; i++) {

            System.out.println(2 * i + 1);

            sum +=2* i;

        }


        System.out.printf("Sum: %d%n", sum);

    }
}
