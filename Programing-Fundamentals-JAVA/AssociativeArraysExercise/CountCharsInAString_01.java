package AssociativeArraysExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString_01 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String text = scanner.nextLine().replaceAll("\\s+", ""); // kogato sreshtne intervali gi zamenq s nishto
        //"text text text".replaceAll -> "texttexttext"
        //символ -> бр. срещанията
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        //HashMap -> няма значение редът на записите
        //LinkedHashMap -> записите се подреждат спрямо реда на добавяне
        //TreeMap -> записите е сортират спрямо техния ключ

        for (char symbol : text.toCharArray()) {
            //"Desi" -> ['D', 'e', 's', 'i']
            /*if (symbol == ' ') {
                continue; //пропуска всичко надолу и преминава към следващия символ
            }*/
            //1. да не съм срещала такъв символ
            if (!symbolsCount.containsKey(symbol)) {
                symbolsCount.put(symbol, 1); // sreshtu simvola da stoi stoinostta 1
            }
            //2. да съм срещала такъв символ
            else {
                int currentCount = symbolsCount.get(symbol); //текущия бр. срещания
                symbolsCount.put(symbol, currentCount + 1);
            }
        }

        //отпечатваме
        //символ -> бр. срещания
        //entry: key (symbol) -> value (count)
        //запис: символ бр. срещания
        symbolsCount.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
