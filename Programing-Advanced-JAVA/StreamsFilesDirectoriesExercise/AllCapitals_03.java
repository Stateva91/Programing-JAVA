package StreamsFilesDirectoriesExercise;

import java.io.*;

public class AllCapitals_03 {
    public static void main(String[] args) throws IOException {
        //1. взимаме всички редове от файл input.txt
        //2. обхождаме всеки един ред -> правим всички букви главни -> записваме реда с главаните букви в нов файл
        String pathToFile = "C:\\Users\\sneji\\OneDrive\\Работен плот\\JavaAdvance\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        //начин 1:
        /*List<String> allLines = Files.readAllLines(Path.of(pathToFile));
        for (String line : allLines) {
            writer.write(line.toUpperCase());
            writer.newLine(); // minava na nov red
        }
        writer.close();*/

        //начин 2:
        BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
        String line = reader.readLine();//chete red po red
        //line == null -> нямаме такъв ред
        while (line != null) {// dokato imat redove
            writer.write(line.toUpperCase());
            writer.newLine();// otpechatva nov red

            line = reader.readLine();
        }

        writer.close();

    }
}
