package FinalExam_04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String validRegexBarcode = "@#+([A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(validRegexBarcode);
        Matcher matcher = null;

        for (int i = 0; i < count; i++) {
            String barcode = scanner.nextLine();
            matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < barcode.length(); j++) {
                    char symbol = barcode.charAt(j);
                    if (Character.isDigit(symbol)) { // ako e chislo
                        sb.append(symbol);
                    }
                }
                if (sb.length()==0) {
                    System.out.println("Product group: 00");
                } else {
                    System.out.println("Product group: " + sb);
                }

            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}


