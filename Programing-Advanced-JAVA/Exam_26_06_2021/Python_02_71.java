package Exam_26_06_2021;

import java.util.Scanner;

public class Python_02_71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pythonLength = 1;
        int n = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine() //"left, left, up, right, up, up"
                .split(", ");

        String[][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int rowPython = 0;
        int colPython = 0;

        int foodCounter = 0;
        int foodFound = 0;

        //ot kade zapochva python
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("s")) {
                    rowPython = row;
                    colPython = col;
                    break;
                } else if (matrix[row][col].equals("f")) {
                    foodCounter++;
                }
            }
        }

        for (String direction : directions) {
            switch (direction) {
                case "right":
                    colPython++;
                    if (colPython >= n) {
                        colPython = 0;
                    }
                    break;
                case "left":
                    colPython--;
                    if (colPython < 0) {
                        colPython = matrix.length - 1;
                    }
                    break;
                case "up":
                    rowPython--;
                    if (rowPython < 0) {
                        rowPython = matrix.length - 1;
                    }
                    break;
                case "down":
                    rowPython++;
                    if (rowPython >= n) {
                        rowPython = 0;
                    }
                    break;
            }

            if (matrix[rowPython][colPython].equals("f")) {
                matrix[rowPython][colPython]="*";
                pythonLength++;
                foodFound++;
                if (foodFound == foodCounter) {
                    System.out.printf("You win! Final python length is %d", pythonLength);
                    return;
                }
            } else if (matrix[rowPython][colPython].equals("e")) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }
        }
        if (foodCounter > foodFound) {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCounter - foodFound);
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
