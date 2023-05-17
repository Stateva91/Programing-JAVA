package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

         int n=Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students=new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String [] line= scanner.nextLine().split("\\s+");
            String name=line[0];
            double grade=Double.parseDouble(line[1]);
            students.putIfAbsent(name, new ArrayList<>());
            students.get(name).add(grade);

        }
        students.entrySet()
                .forEach(entry->{
                    double sum=0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum+=entry.getValue().get(i);
                    }
                    double avg=sum/entry.getValue().size();
                    System.out.print(entry.getKey()+ " -> ");
                    entry.getValue().forEach(e-> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)%n", avg);
                });
    }
}
