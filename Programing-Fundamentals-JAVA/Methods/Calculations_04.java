package Methods;

import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandInput = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());


        switch (commandInput) {
            case "add":
                addNumber(firstNum, secondNum);
                break;
            case "multiply":
                multiplyNumber(firstNum,secondNum);
                break;
            case "subtract":
                subtractNumber(firstNum, secondNum);
                break;
            case "divide":
                divideNumber(firstNum,secondNum);
                break;

        }
    }
        public static  void addNumber(int firstNum, int secondNum){
            int result=firstNum+secondNum;
            System.out.println(result);

        }
        public static  void multiplyNumber(int firstNum, int secondNum){
            int result=firstNum*secondNum;
            System.out.println(result);

        }
    public static  void subtractNumber(int firstNum, int secondNum){
        int result=firstNum-secondNum;
        System.out.println(result);

    }
    public static  void divideNumber(int firstNum, int secondNum){
        int result=firstNum/secondNum;
        System.out.println(result);

    }
    }

