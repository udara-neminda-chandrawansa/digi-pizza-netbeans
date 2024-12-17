package OrderPackage;

import PizzaPackage.Pizza;
import java.util.ArrayList;

public class Order {
    private String orderName;
    private double orderPrice;
    private String orderType;
    private OrderState orderState;
    private ArrayList<Pizza> orderItems;
    
    // Default constructor
    public Order() {
        this.orderItems = new ArrayList<>(); // Initialize orderItems
    }
    
    public Order (String orderName, double orderPrice, String orderType ,OrderState orderState, ArrayList<Pizza> orderItems){
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
        this.orderState = orderState;
        this.orderItems = orderItems;
    }
    
    public String getOrderName(){
        return this.orderName;
    }
    
    public double getOrderPrice(){
        return this.orderPrice;
    }
    
    public String getOrderType(){
        return this.orderType;
    }
    
    public OrderState getOrderState(){
        return this.orderState;
    }
    
    public ArrayList<Pizza> getOrderItems(){
        return this.orderItems;
    }
    
    public void addOrderItem(Pizza newOrderItem){
        this.orderItems.add(newOrderItem);
    }
    
    public void setOrderState(OrderState newState){
        this.orderState = newState;
    }
}

//
// ** Command pattern implementation
//

interface OrderCommand {
    void execute();
}

class CreateOrderCommand implements OrderCommand {
    private Order order;
    private String orderName;
    private double orderPrice;
    private String orderType;

    public CreateOrderCommand(Order order, String orderName, double orderPrice, String orderType) {
        this.order = order;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
    }

    @Override
    public void execute() {
        order = new Order(orderName, orderPrice, orderType, new PlacedState(), new ArrayList<>());
        System.out.println("Order Created: " + orderName);
    }
}

class AddItemCommand implements OrderCommand {
    private Order order;
    private Pizza pizza;

    public AddItemCommand(Order order, Pizza pizza) {
        this.order = order;
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        order.addOrderItem(pizza);
        System.out.println("Pizza Added: " + pizza.getName());
    }
}

class ChangeOrderStateCommand implements OrderCommand {
    private Order order;
    private OrderState newState;

    public ChangeOrderStateCommand(Order order, OrderState newState) {
        this.order = order;
        this.newState = newState;
    }

    @Override
    public void execute() {
        order.setOrderState(newState);
        System.out.println("Order Status Changed to: " + newState.getStatus());
    }
}

class OrderInvoker {
    private OrderCommand command;

    public void setCommand(OrderCommand command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}

//
// ** State pattern implementation
//
interface OrderState {
    void updateStatus(Order order);
    String getStatus();
}

class PlacedState implements OrderState {
    @Override
    public void updateStatus(Order order) {
        order.setOrderState(new PreparationState());
    }

    @Override
    public String getStatus() {
        return "Order Placed";
    }
}

class PreparationState implements OrderState {
    @Override
    public void updateStatus(Order order) {
        order.setOrderState(new ReadyForPickupState());
    }

    @Override
    public String getStatus() {
        return "Preparing Pizza";
    }
}

class ReadyForPickupState implements OrderState {
    @Override
    public void updateStatus(Order order) {
        order.setOrderState(new CompletedState());
    }

    @Override
    public String getStatus() {
        return "Ready for Pickup/Delivery";
    }
}

class CompletedState implements OrderState {
    @Override
    public void updateStatus(Order order) {
        // Final state, no further transitions
    }

    @Override
    public String getStatus() {
        return "Order Completed";
    }
}