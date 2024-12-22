package FeedbackPackage;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

// ** using state pattern for providing status updates to customers
public class StatusNotifier implements PizzaShop {
    // stores the `Observers` in this ArrayList
    private List<Observer> observers = new ArrayList<>();
    private String status;
    // the form in which notifications are shown (needed for JOptionPane dialog boxes)
    private Component component;

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendNotification(String status, Component component) {
        for (Observer observer : observers) {
            observer.recieveStatusUpdate(status, component);
        }
    }
    // display the notification msg after setting status
    public void setStatus(String status, Component component) {
        this.status = status;
        this.component = component;
        sendNotification(status, component);
    }
}