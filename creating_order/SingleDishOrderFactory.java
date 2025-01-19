package creating_order;

public class SingleDishOrderFactory extends OrderFactory {
    @Override
    public Order createOrder() {
        return new SingleDishOrder();
    }
}
