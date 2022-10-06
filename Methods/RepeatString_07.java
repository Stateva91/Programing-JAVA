package Methods;

import java.util.Scanner;

public class RepeatString_07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String inputIndex= scanner.nextLine();
        int n=Integer.parseInt(scanner.nextLine());

        String resultText=repeatString(n, inputIndex);
        System.out.println(resultText);
    }

    public static  String repeatString(int n, String text){

        String result="";
        for (int i = 0; i < n; i++) {
            result=result+text;
            
        }
        return result;

    }
}
