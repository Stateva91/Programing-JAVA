package Exam_22_10_2022;

import java.util.*;

public class EnergyDrinks_01 {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        ArrayDeque<Integer> milligramsOfCaffeine = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(milligramsOfCaffeine::push);

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(energyDrinks::offer);
        int milligrams = 0;

        while (!milligramsOfCaffeine.isEmpty() && !energyDrinks.isEmpty()) {
            int currentMilligrams = milligramsOfCaffeine.peek() * energyDrinks.peek(); // преглед
            milligramsOfCaffeine.pop(); //взима последния и го изтрива

            if (currentMilligrams + milligrams <= 300) {
                energyDrinks.poll();// изтрива
                milligrams += currentMilligrams;
            } else {
                energyDrinks.offer((energyDrinks.poll())); //offer-добавям
                if (milligrams - 30 > 0) {
                    milligrams -= 30;
                }
            }

        }

        if (!energyDrinks.isEmpty()) {
            print(energyDrinks);
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.println("Stamat is going to sleep with " + milligrams + " mg caffeine.");
    }

    private static void print(ArrayDeque<Integer> arrayDeque) {
        List<String> output = new ArrayList<>();

        System.out.print("Drinks left: ");
        while (!arrayDeque.isEmpty()) {
            output.add(arrayDeque.pop().toString());
        }

        System.out.print(String.join(", ", output));
        System.out.println();
    }

    }

