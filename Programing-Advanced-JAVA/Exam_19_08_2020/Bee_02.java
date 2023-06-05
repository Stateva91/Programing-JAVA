package Exam_19_08_2020;

import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] teritory = new char[n][n];
        int beeRow = -1;
        int beeCol = -1;

        for (int i = 0; i < n; i++) {
            char[] singleRow = scanner.nextLine().toCharArray();
                for (int j = 0; j < n; j++) {
                    teritory[i][j] = singleRow[j];
                    if (teritory[i][j] == 'B') {
                        beeRow = i;
                        beeCol = j;
                    }
                }
        }
        int flowers=0;
        String command= scanner.nextLine();
        while (!command.equals("End")){
            teritory[beeRow][beeCol]='.';
            if(command.equals("right") && beeCol!=n-1){
                beeCol++;

            }else if (command.equals("left")&& beeCol!=0){
                beeCol--;

            }else if (command.equals("down") && beeRow!=n-1){
                beeRow++;

            }else if (command.equals("up")&& beeRow!=0){
                beeRow--;

            } else {
                teritory[beeRow][beeCol]='.';
                System.out.println("The bee got lost!");
                break;
            }
            if(teritory[beeRow][beeCol]=='f'){
                flowers++;
            } else if (teritory[beeRow][beeCol]=='O'){
                continue;

            }
            teritory[beeRow][beeCol]='B';

            command= scanner.nextLine();
        }
        if(flowers<5){
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5-flowers);
        }else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }
        printMatrix(n, teritory, beeRow, beeCol);
    }

    private static void printMatrix(int n, char[][] teritory, int beeRow, int beeCol) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(teritory[i][j]);
            }
            System.out.println();

        }
    }

}

