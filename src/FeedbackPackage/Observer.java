package FeedbackPackage;

import java.awt.Component;

// ** using state pattern for providing status updates to customers
interface PizzaShop {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void sendNotification(String status, Component component);
}

interface Observer { // this is inherited by customer
    void recieveStatusUpdate(String status, Component component);
}