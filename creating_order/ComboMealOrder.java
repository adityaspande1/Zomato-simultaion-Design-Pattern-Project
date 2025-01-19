package creating_order;

public class ComboMealOrder implements Order {
    @Override
    public void prepareOrder(String comboName) {
        System.out.println("Preparing a " + comboName);
    }
}