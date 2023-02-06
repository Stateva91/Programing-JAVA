package TextProcessing;

import java.util.Scanner;

public class TextFilter_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String [] banWordArr=scanner.nextLine().split(", ");
        String text= scanner.nextLine();

        for ( String ban: banWordArr) {

            text=text.replace(ban, repeatString("*", ban.length()));
        }
        System.out.println(text);

    }
    public  static  String repeatString(String word, int count){

        String result="";
        for (int i = 0; i < count; i++) {

            result +=word;
        }
        return result;
    }
}
