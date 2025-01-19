package creating_order;

public class ComboMealOrderFactory extends OrderFactory {
    @Override
    public Order createOrder() {
        return new ComboMealOrder();
    }
}
