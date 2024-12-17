package FeedbackPackage;

public class Customer implements Observer {
    private String name;
    private String email;
    private String telNo;

    public Customer(String name, String email, String telNo) {
        this.name = name;
        this.email = email;
        this.telNo = telNo;
    }

    @Override
    public void recieveStatusUpdate(String status) {
        System.out.println("Notification to " + name + ": Your order is now " + status);
    }
}
