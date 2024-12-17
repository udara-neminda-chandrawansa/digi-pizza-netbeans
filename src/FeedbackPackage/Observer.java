package FeedbackPackage;

import java.util.ArrayList;
import java.util.List;

interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void sendNotification(String status);
}

interface Observer {
    void recieveStatusUpdate(String status);
}

class StatusNotifier implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void sendNotification(String status) {
        for (Observer observer : observers) {
            observer.recieveStatusUpdate(status);
        }
    }

    public void setStatus(String status) {
        this.status = status;
        sendNotification(status);
    }
}