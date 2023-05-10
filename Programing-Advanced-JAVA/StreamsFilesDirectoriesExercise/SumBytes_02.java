package StreamsFilesDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        //1. всички редове от файл input.txt
        //2. принтираме сумата от ascii кодовете на символите на всички редове

        String pathToFile = "C:\\Users\\sneji\\OneDrive\\Работен плот\\JavaAdvance\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        long sum = 0; //сума от аски кодовете на всички символи

        //начин 1:
        /*List<String> allLines = Files.readAllLines(Path.of(pathToFile)); //лист с всички редове (текст)

        for (String line : allLines) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
        }
        System.out.println(sum);*/

        //начин 2:
        //byte -> -127 до 128
        //sbyte -> 0 до 256
        byte [] allBytes = Files.readAllBytes(Path.of(pathToFile));
        //масив от аски кодовете на всички символи (включително нов ред и carriage return) във файл
        // ascii = 10 -> символ за нов ред
        // ascii = 13 -> символ, обозначаващ начало на нов ред
        for (byte ascii : allBytes) {
            if (ascii != 13 && ascii != 10) {
                sum += ascii;
            }
        }
        System.out.println(sum);

        //начин 3:
      /*  BufferedReader br=new BufferedReader(new FileReader(pathToFile));
        String line= br.readLine();
        while (line!=null){
            for (int index = 0; index < line.length(); index++) {

                char currentSymbol=line.charAt(index);
                sum+=currentSymbol;
            }

            line= br.readLine();
        }
        System.out.println(sum);
*/
    }
}
