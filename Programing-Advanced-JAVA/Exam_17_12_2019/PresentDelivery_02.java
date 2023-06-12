package Exam_17_12_2019;

import java.util.Scanner;

public class PresentDelivery_02 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         int m=Integer.parseInt(scanner.nextLine());
         int n=Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[n][n];
        fillMatrix(matrix, scanner);

        int santaRow = -1; //на кой ред се намира
        int santaCol = -1; //на коя колона се намира

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                }
            }
        }
        int happyKids=0;
        String command=scanner.nextLine();
        while (!command.equals("Christmas morning")) {
            matrix[santaRow][santaCol]="-";
            switch (command) {
                case "up":
                    //нагоре
                    santaRow--;
                    break;
                case "down":
                    //надолу
                    santaRow++;
                    break;
                case "left":
                    //ляво
                    santaCol--;
                    //проверка дали сме отвън
                    break;
                case "right":
                    //дясно
                    santaCol++;
                    break;
            }
            if(santaRow>=0 && santaCol>=0 && santaRow<n && santaCol<n){
                if(matrix[santaRow][santaCol].equals("-")){
                    matrix[santaRow][santaCol] = "S";
                } else if (matrix[santaRow][santaCol].equals("V")) {
                    matrix[santaRow][santaCol] = "-";
                    matrix[santaRow][santaCol] = "S";
                    m--;
                    happyKids++;
                    if (m == 0) {
                        break;
                    }
                } else if (matrix[santaRow][santaCol].equals("X")) {
                    matrix[santaRow][santaCol] = "-";
                    matrix[santaRow][santaCol] = "S";
                } else if (matrix[santaRow][santaCol].equals("C")) {
                    matrix[santaRow][santaCol] = "-";
                    matrix[santaRow][santaCol] = "S";
                    for (int i = -1; i <= 1; i++) {
                        if (matrix[santaRow + i][santaCol].equals("V") || matrix[santaRow + i][santaCol].equals("X")) {
                            matrix[santaRow + i][santaCol] = "-";
                            m--;
                            happyKids++;
                            if (m == 0) {
                                break;
                            }
                        }
                        if (matrix[santaRow][santaCol + i].equals("V") || matrix[santaRow][santaCol + 1].equals("X")) {
                            matrix[santaRow][santaCol + i] = "-";
                            m--;
                            happyKids++;
                            if (m == 0) {
                                break;
                            }
                        }
                    }
                }
            }
            command = scanner.nextLine();
                }
        if (m == 0) {
            System.out.println("Santa ran out of presents!");
        }
        int niceKidsLeft = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
                if (matrix[i][j].equals("V")) {
                    niceKidsLeft++;
                }
            }
            System.out.println();
        }
        if (niceKidsLeft != 0) {
            System.out.println("No presents for " + niceKidsLeft + " nice kid/s.");
        } else {
            System.out.println("Good job, Santa! " + happyKids + " happy nice kid/s.");
        }
            }
    
    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        //бр. редове = matrix.length
        //бр. колони = matrix.length
        for (int row = 0; row <= matrix.length - 1; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
    }
}
