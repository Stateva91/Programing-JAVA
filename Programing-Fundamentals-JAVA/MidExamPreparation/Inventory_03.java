package MidExamPreparation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory_03 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        List<String> itemsList= Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String input= scanner.nextLine();

        while (!input.equals("Craft!")){
            String[] commandsLine = input.split(" - ");
            String command=commandsLine[0];
            if(command.contains("Collect")){
                String item=commandsLine[1];
                if(!itemsList.contains(item)){
                    itemsList.add(item);
                }

            } else if (command.contains("Drop")){
                String itemDrop=commandsLine[1];

                itemsList.remove(itemDrop);

            }else if (command.contains("Combine Items")){
                String[] items = commandsLine[1].split(":");
                String oldItem=items[0];
                String newItem=items[1];
                if(itemsList.contains(oldItem)){
                    int index=itemsList.indexOf(oldItem);
                    itemsList.add(index+1, newItem);
                }

            }else if (command.contains("Renew")){
                String itemRenew=commandsLine[1];
                if(itemsList.contains(itemRenew)){
                    itemsList.remove(itemRenew);
                    itemsList.add(itemRenew);
                }
            }

            input= scanner.nextLine();
        }
        System.out.println(String.join(", ", itemsList));

    }
}
