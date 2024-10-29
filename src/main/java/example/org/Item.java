package example.org;

public class Item {
    private final double price;
    private final int quantity;

    public Item(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice(double vatRate) {
        double vatAmount = (price * vatRate) / 100;
        return (price + vatAmount) * quantity;
    }

    public double getPrice() {
        return price;
    }
}

