package Exam_26_06_2021;

import java.util.Scanner;

public class Python02 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);
         int n=Integer.parseInt(scanner.nextLine());
         String [] commands=scanner.nextLine().split(",\\s+");

         char [][] matrix=new char[n][n];
         //fill matrix
        for (int row = 0; row < n; row++) {
            matrix[row]=scanner.nextLine().replaceAll(" ", "").toCharArray();

        }
        //find python
        int rowPython=0;
        int colPython=0;
        int countFood=0; // obshto kolichestvo hrana
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char currentElement=matrix[row][col];
                if(currentElement=='s'){
                    rowPython=row;
                    colPython=col;
                } else if (currentElement=='f'){
                    countFood++;
                }
            }
        }
        //moves
        int length=1; // dulzhina na zmiqta
        boolean isDead=false;
        for (String command: commands){
            matrix[rowPython][colPython]='*';
            switch (command){
                case "left":
                    colPython--;
                    break;
                case "right":
                    colPython++;
                    break;
                case "up":
                    rowPython--;
                    break;
                case "down":
                    rowPython++;
                    break;
            }
            //sled premestvane dali sme izlqzli izvun poleto
            if(rowPython<0 || rowPython>=n){ // pokazva che sum otvun
                if(rowPython<0){ //izliza na gore i stava na - red
                    rowPython=n-1; // posledniq red
                }
                if(rowPython>=n){
                    rowPython=0;
                }
            }
            if( colPython<0 || colPython>=n){
                if(colPython<0){
                    colPython=n-1;
                }
                if(colPython>=n){
                    colPython=0;
                }
            }
            if(countFood==0){

                break;
            }
            //proverka kade sme otishli
            if(matrix[rowPython][colPython]=='f'){
                length++;
            } else {
                countFood--;
            }
            if (matrix[rowPython][colPython]=='e') {
                isDead=true;
             break;
            }
            matrix[rowPython][colPython]='s'; // sled premestvane tam kadeto e slagam s
        }

        if(countFood==0){
            System.out.printf("You win! final python length is %d%n",length);
        } else if (isDead){
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten", countFood);
        }
    }
}
