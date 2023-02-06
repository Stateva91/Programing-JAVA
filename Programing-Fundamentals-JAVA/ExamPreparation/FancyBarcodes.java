package ExamPreparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern validBarcode = Pattern.compile("@#+[A-Z][A-Za-z0-9]{4,}[A-Z]@#+");
        Pattern numbersInBarcode = Pattern.compile("[0-9]");

        for (int i = 0; i < n; i++) {
            String productGroup = "";
            String barcode = scanner.nextLine();
            Matcher isValid = validBarcode.matcher(barcode);
            if(isValid.find()){
                Matcher isNumber = numbersInBarcode.matcher(barcode);
                while (isNumber.find()) {
                    productGroup = productGroup + isNumber.group();
                }
                if(productGroup.equals("")){
                    productGroup = "00";
                }
                System.out.println("Product group: " + productGroup);
            } else{
                System.out.println("Invalid barcode");
            }
        }
    }
}
