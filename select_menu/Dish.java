package select_menu;

public class Dish implements MenuItem {
    private String name;
    private double price;

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println(name + " - $" + price);
    }

    @Override
    public double getPrice() {
        return price;
    }
}

