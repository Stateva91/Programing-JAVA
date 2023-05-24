package Exam_13_04_2022;

import java.util.Scanner;

public class Armory_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //бр. редове = бр. колони
        char[][] matrix = new char[n][n];

        int currentRow = 0;
        int currentCol = 0;
        //пълним матрицата
        fillMatrix(scanner, n, matrix);

        for (int row = 0; row < n; row++) { //preminavame prez vseki edin ot redovete
            for (int col = 0; col < n; col++) {
                char currentSymbol = matrix[row][col]; // tekushtiq simvol na suotvetnata poziciq
                if (currentSymbol == 'A') {
                    currentRow = row;
                    currentCol = col;
                }
            }
        }
    }
        private static void fillMatrix(Scanner scanner,int n, char[][] matrix){
            for (int row = 0; row < n; row++) {
                String rowContent = scanner.nextLine(); // "M--"
                char[] rowSymbols = rowContent.toCharArray(); // ['M', '-', '-']
                matrix[row] = rowSymbols; // sreshtu opredelen red mi zastava masiv ot simvoli koito sme poluchili
            }
        }
    }
