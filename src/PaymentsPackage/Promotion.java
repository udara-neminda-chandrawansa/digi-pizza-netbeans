package PaymentsPackage;

public class Promotion {
    private String promo_id;
    private String promo_name;
    private double discount;
    
    public Promotion(String ID, String Name, double Discount){
        this.promo_id = ID;
        this.promo_name = Name;
        this.discount = Discount;
    }
    
    public String getID(){
        return this.promo_id;
    }
    
    public String getName(){
        return this.promo_name;
    }
    
    public double getDiscount(){
        return this.discount;
    }
}
