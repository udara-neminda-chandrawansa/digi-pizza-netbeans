package FeedbackPackage;

import java.awt.Component;
import javax.swing.JOptionPane;

public class Customer implements Observer {
    private String user_id;
    private String username;
    private String password;
    private String email;
    private String telNo;

    public Customer(String id, String name, String password ,String email, String telNo) {
        this.user_id = id;
        this.username = name;
        this.password = password;
        this.email = email;
        this.telNo = telNo;
    }
    
    public String getID(){
        return this.user_id;
    }

    @Override
    public void recieveStatusUpdate(String status, Component component) {
        JOptionPane.showMessageDialog(component, "Notification to " + username + ": Your order is now " + status,
                    "Digi-Pizza | Best Pizzas for you!", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("Notification to " + username + ": Your order is now " + status);
    }
}
