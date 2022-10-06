package ExerciseArrays;

import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int rows=Integer.parseInt(scanner.nextLine()); //брой на редове с числа
        String [] firstArray= new String[rows];
        String [] secondArray= new String[rows];

        //четен ред (2, 4, 6, 8, ...)
        // -> първо число отива във втория; второто число отива в първия

        //нечетен ред (1, 2, 5, 7, ...)
        // -> първо число отива във първия; второто число отива в втория

        for (int i = 1; i <=rows ; i++) {

            String [] number=scanner.nextLine().split(" ");
            String firstNumber=number[0];
            String secondNumber=number[1];

            if(i%2==0){

                //firstNumber отива в secondArray
                secondArray[i - 1] = firstNumber;
                //secondNumber отива в firstArray
                firstArray[i - 1] = secondNumber;
            } else {
                //firstNumber отива в firstArray
                firstArray[i - 1] = firstNumber;
                //secondNumber отива в secondArray
                secondArray[i - 1] = secondNumber;
            }
        }
        //отпечатваме масив от текстове:
        //1. for по index
        //2. foreach по елементите
        //3. String.join !!!! само за масив от текстове !!!!

        System.out.println(String.join(" ", firstArray));
        System.out.println(String.join(" ", secondArray));
            }

        }

