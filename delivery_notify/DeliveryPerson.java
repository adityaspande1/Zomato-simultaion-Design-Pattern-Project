package delivery_notify;
public class DeliveryPerson extends DeliveryTracker implements Observer{
    private String name;

    public DeliveryPerson(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println("Delivery Person " + name + ": Received update - " + status);
    }
}
