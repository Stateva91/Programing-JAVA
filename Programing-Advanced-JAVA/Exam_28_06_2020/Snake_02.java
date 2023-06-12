package Exam_28_06_2020;

import java.util.Scanner;

public class Snake_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine()); //размер на матрицата: бр. редове = бр. колоните = size

        String[][] matrix = new String[size][size];
        fillMatrix(matrix, scanner);

        int snakeRow = -1; //на кой ред се намирa
        int snakeCol = -1; //на коя колона се намира

        int lairFirstRow = -1, lairFirstCol = -1,
                lairSecondRow = -1, lairSecondCol = -1;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (matrix[row][col].equals("S")) {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (matrix[row][col].equals("B")) {
                    if (lairFirstRow == -1) {
                        lairFirstRow = row;
                        lairFirstCol = col;
                    } else {
                        lairSecondRow = row;
                        lairSecondCol = col;
                    }
                }
            }
        }
        int foodQuantities = 0;
        while (foodQuantities < 10) {
            String command = scanner.nextLine();
            matrix[snakeRow][snakeCol]=".";
            switch (command) {
                case "left":
                    snakeCol--;
                    break;
                case "right":
                    snakeCol++;
                    break;
                case "down":
                    snakeRow++;
                    break;
                case "up":
                    snakeRow--;
                    break;
            }

            //proverqvam dali e izlqzla
            if (snakeRow < 0 || snakeRow >= size ||
                    snakeCol < 0 || snakeCol >= size) {
                break;
            }
            if (matrix[snakeRow][snakeCol].equals("*")) {
                foodQuantities++;
            }

            if (snakeRow == lairFirstRow && snakeCol == lairFirstCol) {

             matrix[snakeRow][snakeCol] = ".";

                snakeRow = lairSecondRow;
                snakeCol = lairSecondCol;
            } else if (snakeRow == lairSecondRow && snakeCol == lairSecondCol) {

             matrix[snakeRow][snakeCol] = ".";

                snakeRow = lairFirstRow;
                snakeCol = lairFirstCol;
            }
            matrix[snakeRow][snakeCol] ="S";
        }

        if (foodQuantities >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d\n", foodQuantities);
        for (int i = 0; i < size; i++) {
            // field[i].length
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        //бр. редове = matrix.length
        //бр. колони = matrix.length
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }
}
