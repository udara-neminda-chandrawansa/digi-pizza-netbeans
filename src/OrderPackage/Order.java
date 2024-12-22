package OrderPackage;

import PizzaPackage.Pizza;
import java.util.ArrayList;
import java.util.Map;

public class Order {
    private String order_id;
    private String user_id;
    private String order_name;
    private double order_price;
    private String order_type;
    private OrderState order_state;
    private ArrayList<Map<Pizza, Integer>> order_items;
    
    // Default constructor
    public Order() {
        this.order_items = new ArrayList<>(); // Initialize order_items
    }
    
    public Order (String orderID, String userID, String orderName, double orderPrice, String orderType ,OrderState orderState, ArrayList<Map<Pizza, Integer>> orderItems){
        this.order_id = orderID;
        this.user_id = userID;
        this.order_name = orderName;
        this.order_price = orderPrice;
        this.order_type = orderType;
        this.order_state = orderState;
        this.order_items = orderItems;
    }
    // getters
    public String getOrderID(){
        return this.order_id;
    }
    
    public String getUserID(){
        return this.user_id;
    }
    
    public String getOrderName(){
        return this.order_name;
    }
    
    public double getOrderPrice(){
        return this.order_price;
    }
    
    public String getOrderType(){
        return this.order_type;
    }
    
    public OrderState getOrderState(){
        return this.order_state;
    }
    
    public ArrayList<Map<Pizza, Integer>> getOrderItems(){
        return this.order_items;
    }
    // setters
    public void addOrderItem(Map<Pizza, Integer> newOrderItem){
        this.order_items.add(newOrderItem);
    }
    
    public void setOrderID(String orderID){
        this.order_id = orderID;
    }
    
    public void setUserID(String userID){
        this.user_id = userID;
    }
    
    public void setOrderName(String orderName){
        this.order_name = orderName;
    }
    
    public void setOrderType(String orderType){
        this.order_type = orderType;
    }
    
    public void setOrderPrice(double orderPrice){
        this.order_price = orderPrice;
    }
    
    public void setOrderState(OrderState newState){
        this.order_state = newState;
    }
    // methods of children `DeliveryOrder` & `PickupOrder`
    String pickUp() {return "";}
    
    String acceptDelivery(){return "";}
    
    String getDeliveryAddress() {return "";}
    
    String getCurrentLocation(){return "";}
    
    String getDeliveryEmployee(){return "";}

    void setDeliveryAddress(String deliveryAddress) {}
    
    void setCurrentLocation(String curLocation){}
    
    void setDeliveryEmployee(String deliveryEmp){}
}

//
// ** child classes - Pickup order & Delivery order
//

class PickupOrder extends Order {
    PickupOrder(){} // null constructor
    
    private PickupOrder(String order_id, String user_id ,String order_name, double order_price, String order_type, OrderState order_state, ArrayList<Map<Pizza, Integer>> order_items) {
        super(order_id, user_id ,order_name, order_price, order_type, order_state, order_items); // Call the constructor of the parent class
    }

    @Override
    public String pickUp(){
        return "Order Picked up from Digi-Pizza!";
    }
}

class DeliveryOrder extends Order {
    private String destination;
    private String current_location;
    private String emp_id;
    
    DeliveryOrder(){} // null constructor

    public DeliveryOrder(String order_id, String user_id ,String order_name, double order_price, String order_type, OrderState order_state, ArrayList<Map<Pizza, Integer>> order_items) {
        super(order_id, user_id ,order_name, order_price, order_type, order_state, order_items); // Call the constructor of the parent class
    }
    
    @Override
    public String acceptDelivery(){
        return "Delivery Accepted from Digi-Pizza!";
    }

    // getters and setters
    
    public String getDeliveryAddress() {
        return destination;
    }
    
    public String getCurrentLocation(){
        return this.current_location;
    }
    
    public String getDeliveryEmployee(){
        return this.emp_id;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.destination = deliveryAddress;
    }
    
    public void setCurrentLocation(String curLocation){
        this.current_location = curLocation;
    }
    
    public void setDeliveryEmployee(String emp_id){
        this.emp_id = emp_id;
    }
}


//
// ** Command pattern implementation (for manipulating Orders)
//

interface OrderCommand {
    void execute();
}

class CreateOrderCommand implements OrderCommand {
    private Order order;
    private String orderID;
    private String userID;
    private String orderName;
    private double orderPrice;
    private String orderType;

    public CreateOrderCommand(Order order, String orderID, String userID, String orderName, double orderPrice, String orderType) {
        this.order = order;
        this.orderID = orderID;
        this.userID = userID;
        this.orderName = orderName;
        this.orderPrice = orderPrice;
        this.orderType = orderType;
    }

    @Override
    public void execute() {
        order = new Order(orderID, userID, orderName, orderPrice, orderType, new PlacedState(), new ArrayList<>());
        System.out.println("Order Created: " + orderName);
    }
}

// used for adding pizzas to an order
class AddItemCommand implements OrderCommand {
    private Order order;
    private Map<Pizza, Integer> pizza;

    public AddItemCommand(Order order, Map<Pizza, Integer> pizza) {
        this.order = order;
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        order.addOrderItem(pizza);
    }
}
// used for changing order state (placed, preparing, ready for pickup etc)
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
// invoker
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
// ** State pattern implementation (for deliberating order state/progress)
//
interface OrderState {
    void updateStatus(Order order);
    String getStatus();
}
// user placing the order
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
// order is being prepared by the pizza shop
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
// the pizzas are done and can be picked up/delivered now
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
// user has accepted the order, finishing the process
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