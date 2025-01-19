package creating_order;
public class SingleDishOrder implements Order {
    @Override
    public void prepareOrder(String dishName) {
        System.out.println("Preparing a " + dishName);
    }
}
