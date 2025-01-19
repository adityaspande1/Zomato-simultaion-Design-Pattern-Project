package delivery_notify;
public class Customer extends DeliveryTracker implements Observer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println("Customer " + name + ": Received update - " + status);
    }
}


