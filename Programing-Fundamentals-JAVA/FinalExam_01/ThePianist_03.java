package FinalExam_01;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ThePianist_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n= parseInt(scanner.nextLine());
        Map<String, String>  composerMap=new LinkedHashMap<>();
        Map<String, String>  keyMap=new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String [] input= scanner.nextLine().split("\\|");
           // {piece}|{composer}|{key}
          String piece=input[0];
          String composer=input[1];
          String key=input[2];
          composerMap.put(piece, composer);
          keyMap.put(piece, key);

        }

        String command= scanner.nextLine();
        while (!command.equals("Stop")){
            String piece=command.split("\\|")[1];
           // String key=command.split("\\|")[3];
            //Add|{piece}|{composer}|{key}
            if(command.contains("Add")){
             String composer=command.split("\\|")[2];
            String key=command.split("\\|")[3];
             if(!composerMap.containsKey(piece)){
                 composerMap.put(piece,composer);
                 keyMap.put(piece, key);
                 System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
             } else {
                 System.out.printf("%s is already in the collection!%n", piece);
             }
            }
            //Remove|{piece}
            else if (command.contains("Remove")){
                 if(composerMap.containsKey(piece)){
                     composerMap.remove(piece);
                     keyMap.remove(piece);
                     System.out.printf("Successfully removed %s!%n", piece);
                 } else {
                     System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                 }

            }
            //ChangeKey|{piece}|{new key}
            else if (command.contains("ChangeKey")){
                String newKey=command.split("\\|")[2];

                if(keyMap.containsKey(piece)){
                    keyMap.remove(piece, "");
                    keyMap.put(piece, newKey);
                    System.out.printf("Changed the key of %s to %s!%n", piece, newKey);
                } else {

                    System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                }

            }
            command= scanner.nextLine();
        }
         //{Piece} -> Composer: {composer}, Key: {key}
        for(Map.Entry<String, String> entry: composerMap.entrySet()){
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue(), keyMap.get(entry.getKey()));
        }

    }
}
