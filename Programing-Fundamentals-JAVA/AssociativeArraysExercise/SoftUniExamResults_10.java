package AssociativeArraysExercise;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults_10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //username -> points
        Map<String, Integer> userPoints = new LinkedHashMap<>();
        // language -> count
        Map<String, Integer> languageCount = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] splitArray = input.split("-");
            //1. "{username}-{language}-{points}" -> ["{username}", "{language}", "{points}"]
            //2. "{username}-banned" -> ["{username}", "banned"]
            String username = splitArray[0];
            if (splitArray.length == 3) {
                String language = splitArray[1];
                int points = Integer.parseInt(splitArray[2]);
                //добавяме username и точки
                if (!userPoints.containsKey(username)) {
                    userPoints.put(username, points);
                } else {
                    int currentPoints = userPoints.get(username);
                    if (points > currentPoints) {
                        userPoints.put(username, points);
                    }
                }

                //добавяме брой срещания на езика
                if (!languageCount.containsKey(language)) {
                    languageCount.put(language, 1);
                } else {
                    languageCount.put(language, languageCount.get(language) + 1);
                }

            } else {
                userPoints.remove(username);
            }



            input= scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : userPoints.entrySet()) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languageCount.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

    }
    }

