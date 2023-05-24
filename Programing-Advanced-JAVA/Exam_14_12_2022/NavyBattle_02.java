package Exam_14_12_2022;
import java.util.Scanner;

public class NavyBattle_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int currentRow = -1;
        int currentCol = -1;
        for (int i = 0; i < n; i++) {
            char[] arr = scanner.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = arr[j];
                if (matrix[i][j] == 'S') {
                    currentRow = i;
                    currentCol= j;
                }
            }
        }
        int hits=0;
        int cruisersHit=0;
        String direction = scanner.nextLine();

        while (true) {
            matrix[currentRow][currentCol] = '-';
            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            if(matrix[currentRow][currentCol]=='-'){
                matrix[currentRow][currentCol]='S';
            } else if (matrix[currentRow][currentCol]=='*'){
                matrix[currentRow][currentCol] = 'S';
                hits++;
                if (hits == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", currentRow, currentCol);
                    break;
                }
            }
            if (matrix[currentRow][currentCol] == 'C') {
                matrix[currentRow][currentCol] = 'S';
                cruisersHit++;
                if (cruisersHit == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
       direction= scanner.nextLine();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    }


