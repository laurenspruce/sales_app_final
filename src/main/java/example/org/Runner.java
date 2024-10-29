package example.org;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Runner {
    private final Scanner scanner;
    private final CustomPrompt prompt;
    private final MsgVATReader vatReader;
    private final MsgCostReader costReader;
    private final MsgQuantityReader quantityReader;

    public Runner(Scanner scanner) {
        this.scanner = scanner;
        this.prompt = new CustomPrompt(scanner);
        this.vatReader = new MsgVATReader(prompt);
        this.costReader = new MsgCostReader(prompt);
        this.quantityReader = new MsgQuantityReader(prompt);
    }

    public void run() {
        while (true) {
            double vatRate = vatReader.read();
            List<Item> items = new ArrayList<>();

            while (true) {
                String input = prompt.getString("Enter the item price (or type QUIT to finish): ");
                if (input.equalsIgnoreCase("QUIT")) {
                    break;
                }
                double price = Double.parseDouble(input);
                int quantity = quantityReader.read();

                items.add(new Item(price, quantity));
            }

            Collections.sort(items, (a, b) -> Double.compare(a.getPrice(), b.getPrice()));
            System.out.println("Sorted prices:");
            for (Item item : items) {
                System.out.println("£" + item.getPrice());
            }

            double totalAmount = 0.0;
            for (Item item : items) {
                double itemTotal = item.getTotalPrice(vatRate);
                totalAmount += itemTotal;
                System.out.println("Total for this item: £" + itemTotal);
            }

            System.out.println("Total amount including VAT: £" + totalAmount);

            String decision = prompt.getString("Type CONTINUE to calculate again or QUIT to exit: ");
            if (decision.equalsIgnoreCase("QUIT")) {
                break;
            }
        }
    }
}

