package select_menu;

import java.util.ArrayList;
import java.util.List;

public class MealCombo implements MenuItem {
    private String name;
    private List<MenuItem> items = new ArrayList<>();

    public MealCombo(String name) {
        this.name = name;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    @Override
    public void display() {
        System.out.println("\n" + name + " Combo:");
        for (MenuItem item : items) {
            item.display();
        }
        System.out.println(name + " Total Price: $" + getPrice());
    }

    @Override
    public double getPrice() {
        return items.stream().mapToDouble(MenuItem::getPrice).sum();
    }
}
