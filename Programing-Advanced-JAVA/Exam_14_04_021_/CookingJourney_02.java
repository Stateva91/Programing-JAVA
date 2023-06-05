package Exam_14_04_021_;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CookingJourney_02 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         int n=Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int currentRow=-1;
        int currentCol=-1;
        //ot kade zapochva python
        List<Integer> pillarsCoordinates = new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                 if (matrix[row][col].equals("S")) {
                    currentRow = row;
                    currentCol = col;
                   // break;
                } else if(matrix[row][col].equals("P")){
                    pillarsCoordinates.add(row);
                    pillarsCoordinates.add(col);
                }
            }
        }
        int money=0;
        while (money < 50) {
            String direction = scanner.nextLine();

            matrix[currentRow][currentCol] = "-";

            if (direction.equals("up")) {
                currentRow--;
            } else if (direction.equals("down")) {
                currentRow++;
            } else if (direction.equals("left")) {
                currentCol--;
            } else if (direction.equals("right")) {
                currentCol++;
            }

            if (isInside(n, currentRow, currentCol)) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }

            String newLocation = matrix[currentRow][currentCol];

            if (newLocation.equals("-")) {
                matrix[currentRow][currentCol] = "S";
            } else if (newLocation.equals("P")) {
                pillarsCoordinates.remove((Integer) currentRow);
                pillarsCoordinates.remove((Integer) currentCol);
                matrix[currentRow][currentCol] = "-";
                currentRow = pillarsCoordinates.get(0);
                currentCol = pillarsCoordinates.get(1);
                matrix[currentRow][currentCol] = "S";
            } else {
                money += Integer.parseInt(matrix[currentRow][currentCol]);
                matrix[currentRow][currentCol] = "S";
            }
        }

        if (money < 50) {
            System.out.printf("Money: %d%n", money);
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
            System.out.printf("Money: %d%n", money);
        }

        printMatrix(matrix);



    }
    private static void fillMatrix (String[][]matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
    private static boolean isInside(int n, int startRow, int startCol) {
        return startRow < 0 || startRow >= n || startCol < 0 || startCol >= n;
    }
}
