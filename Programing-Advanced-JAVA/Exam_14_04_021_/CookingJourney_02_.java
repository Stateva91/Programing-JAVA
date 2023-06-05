package Exam_14_04_021_;

import java.util.Scanner;

public class CookingJourney_02_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        //  fillMatrix(matrix, scanner);
        int currentRow = 0;
        int currentCol = 0;

        int firstPillarRow = 0;
        int firstPillarCol = 0;

        int secondPillarRow = 0;
        int secondPillarCol = 0;

        boolean weFoundFirstPillar = false;
        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = input[col];

                if (matrix[row][col].equals("S")) {

                    currentCol = col;
                    currentRow = row;
                }

                if (matrix[row][col].equals("P") && !weFoundFirstPillar) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    weFoundFirstPillar = true;
                }
                if (matrix[row][col].equals("P") && weFoundFirstPillar)
                    secondPillarRow = row;
                secondPillarCol = col;

            }
        }
        int money = 0;

        while (money < 50) {
            String command = scanner.nextLine();

            int oldRow = currentRow;
            int oldCol = currentCol;
            if (command.equals("left")) {
                currentCol--;

            } else if (command.equals("right")) {
                currentCol++;

            } else if (command.equals("up")) {
                currentRow--;

            } else if (command.equals("down")) {
                currentRow++;

            }
            if (currentCol < 0 || currentRow < 0 || currentRow >= n || currentCol >= n) {
                matrix[oldRow][oldCol] = "-";
                break;
            }
            if (currentCol == firstPillarCol && currentRow == firstPillarRow) {
                // trqbva da otidem na vtoriq pilon
                currentCol = secondPillarCol;
                currentRow = secondPillarRow;
                matrix[oldRow][oldCol] = "-";
                matrix[firstPillarRow][firstPillarCol] = "-";
                matrix[currentRow][currentCol] = "S";
            } else if (currentCol == secondPillarCol && currentRow == secondPillarRow) {
                currentCol = firstPillarCol;
                currentRow = firstPillarRow;
                matrix[oldRow][oldCol] = "-";
                matrix[secondPillarRow][secondPillarCol] = "-";
                matrix[currentRow][currentCol] = "S";
            } else if (matrix[currentRow][currentCol].equals("-")) {
                matrix[oldRow][oldCol] = "-";
                matrix[currentRow][currentCol] = "S";
            } else {
                //popadame na klient i trqbva da vzemem parite
                money += Integer.parseInt(matrix[currentRow][currentCol]);
                matrix[oldRow][oldCol] = "-";
                matrix[currentRow][currentCol] = "S";
            }
        }
        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + money);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();

        }
    }
}
