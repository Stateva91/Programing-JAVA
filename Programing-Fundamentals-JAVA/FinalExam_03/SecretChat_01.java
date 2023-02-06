package FinalExam_03;

import java.util.Scanner;

public class SecretChat_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String  message= scanner.nextLine();
        StringBuilder sb=new StringBuilder(message);
        String command= scanner.nextLine();

        while (!command.equals("Reveal")){

            //InsertSpace:|:{index}
            if(command.contains("InsertSpace")){

                int index=Integer.parseInt(command.split(":\\|:")[1]);

                sb.insert(index, " ");
            }
            //Reverse:|:{substring}
            else if (command.contains("Reverse")){
               // String substring=command.split(":\\|:")[1];
                StringBuilder subString=new StringBuilder(command.split(":\\|:")[1]);
                if(sb.toString().contains(subString)){

                    int start= sb.indexOf(String.valueOf(subString.charAt(0)));// startoviq index
                    int end=start+subString.length()-1;// posledniq index
                    sb.delete(start, end+1);
                    subString.reverse();// obrushtam
                    sb.append(subString);

                } else {
                    System.out.println("error");
                    command= scanner.nextLine();
                    continue;
                }
            }
            //ChangeAll:|:{substring}:|:{replacement}
            else if(command.contains("ChangeAll")){

                String substring=command.split(":\\|:")[1];
                String replacement=command.split(":\\|:")[2];
                String updateString=sb.toString().replace(substring, replacement);
                sb=new StringBuilder(updateString);
            }
            System.out.println(sb.toString());
            command= scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", sb.toString());
    }
}
