package TextProcessing;

import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String [] word=scanner.nextLine().split(" ");
        StringBuilder result=new StringBuilder();
        for (String words: word){

            int count=words.length();
            for (int i = 0; i < count; i++) {
                result.append(words);
            }
        }
        System.out.println(result);
    }
    }

