package MultidimensionalArraysLab;

import java.util.Scanner;

public class PositionOf_02 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String [] comnData=scanner.nextLine().split(" "); //prochel sum informaciqta za vsichki koloni
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(comnData[col]);// v 0 red 0 kolona slagame 0 element
            }
        }


        int n=Integer.parseInt(scanner.nextLine());

        boolean isFound=false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col]==n) {
                    isFound = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }

}

