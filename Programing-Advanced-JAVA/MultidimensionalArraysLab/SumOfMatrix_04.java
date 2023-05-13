package MultidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfMatrix_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizeOfMatrix = scanner.nextLine().split(", ");
        int rows=Integer.parseInt(sizeOfMatrix[0]);
        int cols=Integer.parseInt(sizeOfMatrix[1]);
        int[][] matrix=new int[rows][cols];

        for (int row = 0; row < rows; row++) {

          /*  int [] rowOfMatrix= Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row]=rowOfMatrix; */
            String [] rowOfMatrix= scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=Integer.parseInt(rowOfMatrix[col]);

            }
        }
          int sum=0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum=sum+matrix[row][col];

            }

        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
