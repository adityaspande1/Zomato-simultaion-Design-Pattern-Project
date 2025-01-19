package delivery_notify;
public class Restaurant extends DeliveryTracker implements Observer {
    private String name;

    public Restaurant(String name) {
        this.name = name;
    }

    @Override
    public void update(String status) {
        System.out.println("Restaurant " + name + ": Received update - " + status);
    }
}


