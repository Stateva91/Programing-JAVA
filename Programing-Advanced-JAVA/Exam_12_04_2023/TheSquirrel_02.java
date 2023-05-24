package Exam_12_04_2023;

import java.util.Scanner;

public class TheSquirrel_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hazelnuts = 0; //брой на лешниците (цел = 3)
        boolean isTrap = false; //дали сме попаднали в капан

        int size = Integer.parseInt(scanner.nextLine()); //размер на квадратна матрицата (редове = колони = size)
        String [] directions = scanner.nextLine() //"left, left, up, right, up, up"
                .split(", "); //["left", "left", "up", "right", "up", "up"]

        char [][] field = createMatrix(size, scanner); //полето за движение

        int squirrelRow = -1; //ред на катерицата
        int squirrelCol = -1; //колона на катерицата

        //намираме катерицата
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (field[row][col] == 's') {
                    squirrelRow = row;
                    squirrelCol = col;
                }
            }
        }

        //движения на катерицата
        for (String direction : directions) {
            //direction -> "left", "right", "up", "down"
            if (direction.equals("left")) {//колона - 1
                //1. проверка дали там където отиваме е вътре в матрицата
                if (isInside(squirrelCol - 1, size)) {
                    //можем да се движим -> местим катерицата
                    field[squirrelRow][squirrelCol] = '*';
                    squirrelCol -= 1; //местене
                    //проверка на какво поле сме отишли
                    if (field[squirrelRow][squirrelCol] == 't') {
                        //trap
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    //извън матрицата
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            } else if (direction.equals("right")) {//колона + 1
                //1. проверка дали там където отиваме е вътре в матрицата
                if (isInside(squirrelCol + 1, size)) {
                    //можем да се движим -> местим катерицата
                    squirrelCol += 1;
                    //проверка на какво поле сме отишли
                    if (field[squirrelRow][squirrelCol] == 't') {
                        //trap
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    //извън матрицата
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            } else if (direction.equals("up")) {//ред - 1
                //1. проверка дали там където отиваме е вътре в матрицата
                if (isInside(squirrelRow - 1, size)) {
                    //можем да се движим -> местим катерицата
                    squirrelRow -= 1;
                    //проверка на какво поле сме отишли
                    if (field[squirrelRow][squirrelCol] == 't') {
                        //trap
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    //извън матрицата
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            } else if (direction.equals("down")) {//ред + 1
                //1. проверка дали там където отиваме е вътре в матрицата
                if (isInside(squirrelRow + 1, size)) {
                    //можем да се движим -> местим катерицата
                    squirrelRow += 1;
                    //проверка на какво поле сме отишли
                    if (field[squirrelRow][squirrelCol] == 't') {
                        //trap
                        isTrap = true;
                        System.out.println("Unfortunately, the squirrel stepped on a trap...");
                        break;
                    } else if (field[squirrelRow][squirrelCol] == 'h') {
                        hazelnuts++;
                        field[squirrelRow][squirrelCol] = 's';
                    }
                } else {
                    //извън матрицата
                    isTrap = true;
                    System.out.println("The squirrel is out of the field.");
                    break;
                }
            }

            if (hazelnuts == 3) {
                System.out.println("Good job! You have collected all hazelnuts!");
                break;
            }
        }

        if (hazelnuts >= 3 || isTrap) {
            System.out.println("Hazelnuts collected: " + hazelnuts);
        } else if (!isTrap){
            //isTrap
            //true -> капан или извън матрицата
            //false -> не сме нито в капан и нито извън матрицата
            //прекъснали цикъла и сме минали през всички посоки -> не сме в капан или извън матрицата, не сме събрали лешниците
            System.out.println("There are more hazelnuts to collect.");
            System.out.println("Hazelnuts collected: " + hazelnuts);
        }


    }

    private static char[][] createMatrix(int size, Scanner scanner) {
        //size -> размер на матрицата (size = редове = колони)
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            char[] rowData = scanner.nextLine().toCharArray();// въведения ред от конзолата
            //Начин 1: matrix[row] = rowData;

            //Начин 2:
            for (int col = 0; col < size; col++) {
                char currentSymbol = rowData[col];
                matrix[row][col] = currentSymbol;
            }
        }

        return matrix;
    }

    private static boolean isInside (int number, int size) {
        return number >= 0 && number < size;
    }
}
