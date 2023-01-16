package ExerciseDataTypesAndVariables;

import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int people=Integer.parseInt(scanner.nextLine());
        int capacity=Integer.parseInt(scanner.nextLine());

        double course=1.0*people/capacity;
        int  fullCourses= (int) Math.ceil(course);

        System.out.println(fullCourses);

    }
}
