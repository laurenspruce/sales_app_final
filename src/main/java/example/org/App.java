package example.org;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Runner runner = new Runner(scanner);
        runner.run();
        scanner.close();
    }
}
