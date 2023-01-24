package ExerciseList;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<Integer> numbers= Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command= scanner.nextLine();

        while (!command.equals("End")){

            //Add {number} - add number at the end
            if(command.contains("Add")){

                int number=Integer.parseInt(command.split("\\s+")[1]);
                numbers.add(number);
            }
            //· Insert {number} {index} - insert number at given index
            else if (command.contains("Insert")){
                int number=Integer.parseInt(command.split("\\s+")[1]);
                int index=Integer.parseInt(command.split("\\s+")[2]);
                if(isValidIndex(index, numbers)) {
                    numbers.add(index, number);
                } else {

                    System.out.println("Invalid index");
                }

            }
            //· Remove {index} - remove that index
            else if (command.contains("Remove")){
                int indexRemove=Integer.parseInt(command.split("\\s+")[1]);
                if(isValidIndex(indexRemove, numbers)){
                    numbers.remove(indexRemove);
                } else {

                    System.out.println("Invalid index");
                }

            }
            //· Shift left {count} - first number becomes last 'count' times
            else if (command.contains("Shift left")){

                int count= Integer.parseInt(command.split("\\s+")[2]);
                //1. взимам първото число от списъка -> index = 0
                for (int time = 1; time <= count; time++) {
                    int firstNumber = numbers.get(0);
                    //2. премахвам по индекс първото число от списъка -> {4, 6, 7, 1}
                    numbers.remove(0);
                    //3. добавям го накрая на списъка -> {4, 6, 7, 1, 3}
                    numbers.add(firstNumber);
                }
            }
            //· Shift right {count} - last number becomes first 'count' times
            else if (command.contains("Shift right")) {
                //•	"Shift right {count}" - last number becomes first 'count' times
                //"Shift right 3".split(" ") -> ["Shift", "right", "3"]
                int countShiftRight = Integer.parseInt(command.split("\\s+")[2]);
                //повтаряме дейност -> countShiftRight пъти
                for (int time = 1; time <= countShiftRight; time++) {
                    //last number becomes first
                    //{3, 4, 6, 7, 1}
                    //1. взимам последното число от списъка -> index = size - 1
                    int lastNumber = numbers.get(numbers.size() - 1);
                    //2. премахвам последното число от списъка -> {3, 4, 6, 7}
                    numbers.remove(numbers.size() - 1);
                    //3. добавям го в началото на списъка -> {1, 3, 4, 6, 7}
                    numbers.add(0, lastNumber);
                }
            }

            command= scanner.nextLine();
        }
        for (int n:numbers) {
            System.out.print(n + " ");
        }
    }
    public static boolean isValidIndex(int index, List<Integer> num){
        return index>=0 && index<=num.size()-1;
    }
}
