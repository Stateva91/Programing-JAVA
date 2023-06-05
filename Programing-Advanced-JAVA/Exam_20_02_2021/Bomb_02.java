package Exam_20_02_2021;

import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",");

        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int currentRow = -1;
        int currentCol = -1;
        int bombCounter = 0;
        int bombsFound = 0;
        //ot kade zapochva
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (matrix[row][col].equals("s")) {
                    currentRow = row;
                    currentCol = col;
                    // break;
                } else if (matrix[row][col].equals("B")) {
                    bombCounter++;
                }
            }
        }

        for (String direction : directions) {

            if (direction.equals("up")) {
                if (currentRow != 0) {
                    currentRow--;
                }
            } else if (direction.equals("down")) {
                if (currentRow != n - 1) {
                    currentRow++;
                }
            } else if (direction.equals("left")) {
                if (currentCol != 0) {
                    currentCol--;
                }
            } else if (direction.equals("right")) {
                if (currentCol != n - 1) {
                    currentCol++;
                }
            }

            if (matrix[currentRow][currentCol].equals("B")) {
                System.out.println("You found a bomb!");
                matrix[currentRow][currentCol] = "+";
                bombsFound++;
                if (bombsFound == bombCounter) {
                    System.out.println("Congratulations! You found all bombs!");
                    return;
                }
            } else if (matrix[currentRow][currentCol].equals("e")) {
                System.out.printf("END! %d bombs left on the field%n", bombCounter - bombsFound);
                return;
            }
        }

        if (bombCounter > bombsFound) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCounter - bombsFound, currentRow, currentCol);
        }
    }

    private static void fillMatrix (String[][]matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            //scanner.nextLine() -> "1 2 3"
            //scanner.nextLine().split(" ") -> ["1", "2", "3"]
            matrix[row] = scanner.nextLine().split("\\s+");
        }
    }
}