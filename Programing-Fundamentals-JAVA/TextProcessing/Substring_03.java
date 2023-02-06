package TextProcessing;

import java.util.Scanner;

public class Substring_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text= scanner.nextLine();
        String text2= scanner.nextLine();

        int index=text2.indexOf(text);

        while (index!=-1){

            text2=text2.replace(text, "");
            index=text2.indexOf(text);

        }
        System.out.println(text2);


    }
}
