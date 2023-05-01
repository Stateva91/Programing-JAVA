package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         Scanner scanner=new Scanner(System.in);

        int[] coordinates = getCoordinates(scanner);
        Point bottomLeft = new Point(coordinates[0], coordinates[1]);
        Point topRight = new Point(coordinates[2], coordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            coordinates = getCoordinates(scanner);
            Point X = new Point(coordinates[0], coordinates[1]);
            System.out.println(rectangle.contains(X));
        }
    }

        private static int[] getCoordinates(Scanner scanner) {
            return Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
    }

