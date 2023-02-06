package ExerciseTextProcessing;

import java.util.Scanner;

public class ExtractFile_03 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String path= scanner.nextLine();
        String [] pathPars=path.split("\\\\");
        String fullName=pathPars[pathPars.length-1]; // vzimam poseldniq element
        String fileName=fullName.split("\\.")[0];
        String extension=fullName.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
