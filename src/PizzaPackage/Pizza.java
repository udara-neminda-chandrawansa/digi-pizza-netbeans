package PizzaPackage;

public class Pizza {

    private String pizza_id;
    private String user_id;
    private String pizza_name;
    private String crust;
    private String sauce;
    private String cheese;
    private String toppings;
    private Size size;
    private double price;
    private int rating;
    // using PizzaBuilder, create a pizza (Builder method implementation)
    private Pizza(PizzaBuilder builder) {
        this.pizza_id = builder.pizza_id;
        this.user_id = builder.user_id;
        this.pizza_name = builder.pizza_name;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.size = builder.size;
        this.rating = builder.rating;
        calculatePrice();
    }

    private void calculatePrice() {
        double basePrice = 1000.0; // Base price for the pizza
        double toppingPrice = 100.5; // Price per topping
        double crustPrice = 0.0; // Additional cost based on crust
        double cheesePrice = 0.0; // Additional cost based on cheese
        double saucePrice = 0.0; // Additional cost based on sauce
        
        // Adjust the base price based on crust
        switch (crust) {
            case "Thin Crust":
                crustPrice = 100.0;
                break;
            case "Medium Crust":
                crustPrice = 200.0;
                break;
            default: // Thick crust
                crustPrice = 300.0;
        }

        // Adjust the price based on cheese type
        switch (cheese) {
            case "Parmesan":
                cheesePrice = 100.0;
                break;
            case "Mozzarella":
                cheesePrice = 200.2;
                break;
            default: // Chedder
                cheesePrice = 130.5;
        }

        // Adjust the price based on sauce type
        switch (sauce) {
            case "Tomato Sauce":
                saucePrice = 340.5;
                break;
            case "Alfredo Sauce":
                saucePrice = 210.0;
                break;
            default: // Garlic Sauce
                saucePrice = 150.2;
        }
        
        // Adjust the price based on toppings type
        switch (toppings) {
            case "Pepperoni":
                toppingPrice = 140.6;
                break;
            case "Bell Peppers":
                toppingPrice = 110.3;
                break;
            default: // Pineapple
                toppingPrice = 120.4;
        }

        // Calculate total price
        price = basePrice; // Start with the base price
        price += crustPrice; // Add the crust cost
        price += cheesePrice; // Add the cheese cost
        price += saucePrice; // Add the sauce cost
        price += toppingPrice; // Add the price of toppings
        price *= size.getPriceMultiplier(); // Adjust for size multiplier
        price = Math.round(price * 100.0) / 100.0; // Round up the value
    }

    // Getters
    public String getID(){
        return pizza_id;
    }
    
    public String getUserID(){
        return user_id;
    }
    
    public String getName() {
        return pizza_name;
    }

    public String getCrust() {
        return crust;
    }

    public String getSauce() {
        return sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public String getToppings() {
        return toppings;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
    
    public double getRating() {
        return rating;
    }
    
    // set rating
    public void setRating(int newRating){
        this.rating = newRating;
    }

    // ** Builder Pattern Implementation
    public static class PizzaBuilder {
        private String pizza_id;
        private String user_id;
        private String pizza_name;
        private String crust;
        private String sauce;
        private String cheese;
        private String toppings;
        private Size size = Size.MEDIUM;
        private int rating;
        
        public PizzaBuilder withID(String ID){
            this.pizza_id = ID;
            return this;
        }
        
        public PizzaBuilder withUserID(String userID){
            this.user_id = userID;
            return this;
        }

        public PizzaBuilder withName(String name) {
            this.pizza_name = name;
            return this;
        }

        public PizzaBuilder withCrust(String crust) {
            this.crust = crust;
            return this;
        }

        public PizzaBuilder withSauce(String sauce) {
            this.sauce = sauce;
            return this;
        }

        public PizzaBuilder withCheese(String cheese) {
            this.cheese = cheese;
            return this;
        }

        public PizzaBuilder withTopping(String topping) {
            this.toppings = topping;
            return this;
        }

        public PizzaBuilder withSize(Size size) {
            this.size = size;
            return this;
        }
        
        public PizzaBuilder withRating(int rating){
            this.rating = rating;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    // Enums for Pizza Size
    public enum Size {
        SMALL(0.8), MEDIUM(1.0), LARGE(1.2);

        private final double priceMultiplier;

        Size(double priceMultiplier) {
            this.priceMultiplier = priceMultiplier;
        }

        public double getPriceMultiplier() {
            return priceMultiplier;
        }
    }
}