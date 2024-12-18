package FeedbackPackage;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

interface PizzaShop {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void sendNotification(String status, Component component);
}

interface Observer {
    void recieveStatusUpdate(String status, Component component);
}