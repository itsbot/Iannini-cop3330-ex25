/*
 *  UCF COP3330 Fall 2021 Exercise 25 Solution
 *  Copyright 2021 Patrick Iannini
 */
package Exercise25;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Exercise25 {
    public static int passwordValidator(String input) {
        boolean num = Pattern.matches("\\d+", input); // Only numbers
        if (input.length() < 8) {
            if (num) {
                return 0; // Very weak
            } return 1; // Weak
        }
        boolean special = Pattern.matches("\\w+", input);
        if (special) {
            return 2; // Strong
        }
        return 3; // Very strong
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter a password: ");
        String input = sc.next();

        int strength = passwordValidator(input);
        String strengthOut = switch (strength) {
            case 0 -> "very weak";
            case 1 -> "weak";
            case 2 -> "strong";
            case 3 -> "very strong";
            default -> throw new IllegalStateException("Unexpected value: " + strength);
        };
        System.out.println("The password '"+input+"' is a "+strengthOut+" password.");
    }
}
