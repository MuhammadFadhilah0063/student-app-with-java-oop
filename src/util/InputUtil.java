package util;

import java.util.Scanner;

public class InputUtil {

    public static Scanner scanner = new Scanner(System.in);

    public static String input(String info) {
        System.out.print(info + " : ");
        var value = scanner.nextLine();

        return value;
    }

}
