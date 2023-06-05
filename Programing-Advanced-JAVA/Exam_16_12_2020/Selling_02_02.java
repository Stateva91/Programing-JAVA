package Exam_16_12_2020;

import java.util.Scanner;

public class Selling_02_02 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         int n=Integer.parseInt(scanner.nextLine());
         char [][] matrix=new char[n][n];
         //read matrix
        for (int row = 0; row < n; row++) {
            matrix[row]=scanner.nextLine().toCharArray();

        }

    }
}
