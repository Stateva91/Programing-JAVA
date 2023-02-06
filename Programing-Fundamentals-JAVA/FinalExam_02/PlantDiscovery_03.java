package FinalExam_02;

import java.util.*;

public class PlantDiscovery_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> plants=new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String plant = input.split("<->")[0];
            String rarity = input.split("<->")[1];
            plants.putIfAbsent(plant, new ArrayList<>());
            if (plants.get(plant).isEmpty()) {
                plants.get(plant).add(rarity);
            } else {
                plants.get(plant).set(0, rarity);
            }
        }

        String command= scanner.nextLine();
        String line=command.split(":\\s+")[0];
        String plant = command.split(": ")[1].split(" - ")[0];
        while (!command.equals("Exhibition")){
           if(plants.containsKey(plant)) {
               if (line.contains("Rate")) {
                   //Rate: {plant} - {rating}
                   String rating =command.split(":\\s+")[1].split(" - ")[1];
                   plants.get(plant).add(rating);
                   
               } else if (line.contains("Update")) {
                   //Update: {plant} - {new_rarity}
                   String newRarity =command.split(":\\s+")[1].split(" - ")[1];
                  plants.get(plant).set(0, newRarity);

               } else if (line.contains("Reset")) {
                   //Reset: {plant}
                   String currentRarity = plants.get(plant).get(0);
                   plants.get(plant).clear();
                   plants.get(plant).add(currentRarity);

               }
           } else {
               System.out.println("error");
           }

            command=scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, List<String>> entry : plants.entrySet()) {
            double rating = 0;
            double averageRating = 0;
            if (entry.getValue().size() > 1) {
                for (int i = 1; i < entry.getValue().size(); i++) {
                    rating += Double.parseDouble(entry.getValue().get(i));
                }
                averageRating = rating / (entry.getValue().size() - 1);
            }

            System.out.printf("- %s; Rarity: %s; Rating: %.2f%n", entry.getKey(), entry.getValue().get(0), averageRating);
        }
    }
}
