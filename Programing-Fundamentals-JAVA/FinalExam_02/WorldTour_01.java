package FinalExam_02;
import java.util.Scanner;

public class WorldTour_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String stops= scanner.nextLine();
        StringBuilder destination= new StringBuilder(stops);
        String command= scanner.nextLine();

        while (!command.equals("Travel")){
           // String [] data=command.split(" : ");
          //  String action=data[0];
           // Add Stop:{index}:{string}"
            if(command.contains("Add Stop")){
                int index=Integer.parseInt(command.split(":")[1]);
                String stringText=command.split(":")[2];
                if(index>=0 && index<=destination.length()-1){

                    destination.insert(index, stringText);

                }
            }
            //Remove Stop:{start_index}:{end_index}"
            else if(command.contains("Remove Stop")){
                int startIndex=Integer.parseInt(command.split(":")[1]);
                int endIndex=Integer.parseInt(command.split(":")[2]);
                if(isValidIndex(startIndex, destination) && isValidIndex(endIndex, destination)){

                    destination.delete(startIndex, endIndex+1);
                }

            }
            //Switch:{old_string}:{new_string}
            else if(command.contains("Switch")){
             String oldString=command.split(":")[1];
             String newString=command.split(":")[2];
             if(stops.contains(oldString)){

                 String update=destination.toString().replace(oldString, newString);
                 destination=new StringBuilder(update);

             }

            }

            command= scanner.nextLine();
            System.out.println(destination);
        }
        System.out.printf("Ready for world tour! Planned stops: %s", destination);
    }
    public  static boolean isValidIndex(int index, StringBuilder builder){

           return index>=0 && index<=builder.length()-1;
    }
}
