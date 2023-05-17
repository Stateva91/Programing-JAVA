package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        Map<String, Integer> students= new LinkedHashMap<>();
        students.put("Ivan", 6);
        students.put("Pesho", 4);
        students.put("Asen", 6);
        students.put("Georgi", 3);

     //   students.values().forEach(System.out::println); // printira samo stoinostite
     //   students.keySet().stream().forEach(System.out::println); // samo kluchovete
     //   students.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " "+ entry.getValue()));

        students
                .entrySet()
                .stream()
                .sorted(
                     /*   (left, right)->{
                           return left.getValue().compareTo(right.getValue());
                        }*/
                        (left, right)->{
                           int result= right.getValue().compareTo(left.getValue());
                           if(result==0){ // the grades are equal
                               result=left.getKey().compareTo(right.getKey());

                           }
                           return  result;
                        }
                )
                .forEach(entry-> System.out.println(entry.getKey() + " "+ entry.getValue()));

    }
}
