package OrderPackage;

public class DeliveryGuy {
    private String emp_id;
    private String email;
    private String tel_no;
    
    public DeliveryGuy(String empID, String email, String telNo){
        this.emp_id = empID;
        this.email = email;
        this.tel_no = telNo;
    }
    
    public String getID(){
        return this.emp_id;
    }
    
    public String makeDelivery(){
        return "Delivery made by Employee: " + this.emp_id;
    }
}
