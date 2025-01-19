import java.util.Scanner;

import creating_order.*;
import select_menu.*;
import delivery_notify.*;

public class ZomatoSimulation {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("===== Menu =====");
        MenuItem pasta = new Dish("Pasta", 8.99);
        MenuItem burger = new Dish("Burger", 6.99);
        MenuItem fries = new Dish("Fries", 3.49);

        MealCombo lunchSpecial = new MealCombo("Lunch Special");
        lunchSpecial.addItem(pasta);
        lunchSpecial.addItem(fries);

        MealCombo familyMeal = new MealCombo("Family Meal");
        familyMeal.addItem(burger);
        familyMeal.addItem(lunchSpecial); 

        System.out.println("Individual Dish:");
        pasta.display();
        lunchSpecial.display();
        familyMeal.display();

        System.out.println("\n===== Place an Order =====");
        OrderFactory orderFactory;
        Scanner sc = new Scanner(System.in);
        System.out.println("Type of meal? (Combo/Single):  ");
        String userSelection = sc.nextLine(); 
        String orderName;

        if (userSelection.equalsIgnoreCase("single")) {
            System.out.println("Enter Dish Name: ");
            orderName = sc.nextLine();
            orderFactory = new SingleDishOrderFactory();

        } else if (userSelection.equalsIgnoreCase("combo")) {
            System.out.println("Enter Combo Name: ");
            orderName = sc.nextLine();
            orderFactory = new ComboMealOrderFactory();

        } else {
            throw new IllegalArgumentException("Invalid order type");
        }
        Order order = orderFactory.createOrder();
        order.prepareOrder(orderName);
        System.out.println("Enter the restaurant name: ");
        String restaurantName = sc.nextLine();
        System.out.println("Enter your good name: ");
        String clientName = sc.nextLine();
        System.out.println("\n===== Delivery Tracking =====");
        DeliveryTracker tracker = new DeliveryTracker();

        Customer cdt= new Customer(clientName);
        Restaurant rdt = new Restaurant(restaurantName);
        DeliveryPerson dpdt = new DeliveryPerson("Vivek");

        Observer customer = new Customer(clientName);
        Observer restaurant = new Restaurant(restaurantName);
        Observer deliveryPerson = new DeliveryPerson("Vivek");

        tracker.addObserver(customer);
        tracker.addObserver(restaurant);
        tracker.addObserver(deliveryPerson);

        cdt.addObserver(restaurant);
        
        rdt.addObserver(customer);
        rdt.addObserver(deliveryPerson);

        dpdt.addObserver(restaurant);
        dpdt.addObserver(customer);

        cdt.setStatus(clientName + " has placed order !!!");
        Thread.sleep(2000);
        rdt.setStatus(restaurantName + " has received " + orderName + " from " + clientName);
        Thread.sleep(2000);
        rdt.setStatus("Preparing " + orderName);
        Thread.sleep(2000);
        rdt.setStatus("Parcel handed over to delivery person named Vivek");
        Thread.sleep(2000);
        dpdt.setStatus("Parcel out for delivery");
        Thread.sleep(2000);
        dpdt.setStatus("Parcel delivered successfully to " + clientName);
        Thread.sleep(2000);
        
    }
}
