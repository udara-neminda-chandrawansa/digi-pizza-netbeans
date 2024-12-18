package FeedbackPackage;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;


public class StatusNotifier implements PizzaShop {
    private List<Observer> observers = new ArrayList<>();
    private String status;
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

    public void setStatus(String status, Component component) {
        this.status = status;
        this.component = component;
        sendNotification(status, component);
    }
}