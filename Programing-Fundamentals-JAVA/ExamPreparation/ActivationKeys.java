package ExamPreparation;

import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String activationKe= scanner.nextLine();

        String inputLine= scanner.nextLine();
        while (!inputLine.equals("Generate")){
            String [] tokens= inputLine.split(">>>");
            String command=tokens[0];
            int startIndex=0;
            int endIndex=0;
            String substring="";
            switch (command){
                case "Contains":
                    substring=tokens[1];
                    if(activationKe.contains(substring)){
                        System.out.printf("%s contains %s%n",activationKe,substring);
                    } else {
                        System.out.println("Substring not found!");
                    }

                    break;
                case "Flip":
                    String upperOrLower=tokens[1];
                    startIndex=Integer.parseInt(tokens[2]);
                    endIndex=Integer.parseInt(tokens[3]);
                    substring=activationKe.substring(startIndex, endIndex);
                    if(upperOrLower.equals("Upper")){
                        activationKe=activationKe.replace(substring, substring.toUpperCase());
                    } else if(upperOrLower.equals("Lower")){
                        activationKe=activationKe.replace(substring, substring.toLowerCase());
                    }
                    System.out.println(activationKe);

                    break;
                case "Slice":
                    startIndex=Integer.parseInt(tokens[1]);
                    endIndex=Integer.parseInt(tokens[2]);
                    substring=activationKe.substring(startIndex, endIndex);
                    activationKe=activationKe.replace(substring, "");// zamestvam go s nishto i vsushnost go iztrivam
                    System.out.println(activationKe);
                    break;
            }
            inputLine= scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", activationKe);
    }

    }

