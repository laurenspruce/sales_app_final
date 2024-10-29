package example.org;

import java.util.Scanner;

public class CustomPrompt implements ICustomPrompt {
    private final Scanner scanner;

    public CustomPrompt(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    @Override
    public double getDouble(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    @Override
    public int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }
}
