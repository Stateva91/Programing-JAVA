package ExamPreparation;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String command = scanner.nextLine();

        while (!command.equals("Done")) {

            if (command.contains("TakeOdd")) {
                String newPass = getCharsOnOddPosition(text);
                text = newPass;
                System.out.println(newPass);

            } else if (command.contains("Cut")) {
                //Cut {index} {length}"
                int index = Integer.parseInt(command.split("\\s+")[1]);
                int length = Integer.parseInt(command.split("\\s+")[2]);
                String textRemove = text.substring(index, index + length);// tekstut koito trqbva da premahna
                text = text.replace(textRemove, "");// zamesti mi parvoto rreshtane na teksta s nishto
                System.out.println(text);

            } else if (command.contains("Substitute")) {
                //Substitute {substring} {substitute}
                String substring = command.split("\\s+")[1];
                String substitute = command.split("\\s+")[2];
                if (text.contains(substring)) {

                    text = text.replaceAll(substring, substitute);
                    System.out.println(text);
                } else {

                    System.out.println("Nothing to replace!");
                }
            }

                command = scanner.nextLine();
            }

        System.out.println( "Your password is: "+ text);
    }
    private static String getCharsOnOddPosition(String password) {
        //vsichki indeksi na nechetni indeksi
        StringBuilder newPassword=new StringBuilder();
        for (int i = 0; i <= password.length()-1; i++) {
            if(i%2!=0){
                char currentSymbol=password.charAt(i);
                newPassword.append(currentSymbol);
            }
        }
        return newPassword.toString();
    }
}
