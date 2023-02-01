package AssociativeArraysExercise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class CompanyUsers_08 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String command= scanner.nextLine();
        LinkedHashMap<String, List<String>> company= new LinkedHashMap<>();
        while (!command.equals("End")){
            //"{companyName} -> {employeeId}"
            String [] data=command.split(" -> ");
            String name=data[0];
            String employee=data[1];

            if(!company.containsKey(name)){

                company.put(name, new ArrayList<>());
            }
            if (company.containsKey(name) && !company.get(name).contains(employee)) {
                company.get(name).add(employee);
            }
            //  company.get(name).add(employee);

            command= scanner.nextLine();
        }
        for (var entry : company.entrySet()) {
            System.out.println(entry.getKey());
            for (String ids : entry.getValue()) {
                System.out.println("-- "+ ids);
            }
        }
    }
}
