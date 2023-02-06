package FinalExam_01;

import java.util.Scanner;

public class TheImitationGame_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String message= scanner.nextLine();
        String command= scanner.nextLine();
        while (!command.equals("Decode")){
            String[] data=command.split("\\|");
            String action=data[0];
            if(action.contains("Move")){
                //Move {number of letters}

                int number=Integer.parseInt(data[1]);
                String firstPart=message.substring(0, number); // vzima purvite do number
                String secondPart=message.substring(number); // vzima poslednite
                message=secondPart.concat(firstPart);// na vtoriq dolepq purvite simvoli


            }
            else if (action.contains("Insert")){
                //Insert {index} {value}
                int index=Integer.parseInt(data[1]);
                String element=data[2];
                String first=message.substring(0, index);
                String second=message.substring(index);
                message=first.concat(element).concat(second);

            }
            else if (action.contains("ChangeAll")){
                //ChangeAll {substring} {replacement}
                String substring=data[1];
                String replacement=data[2];

                message=message.replace(substring,replacement);

            }
            command= scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s%n", message);

    }
}
