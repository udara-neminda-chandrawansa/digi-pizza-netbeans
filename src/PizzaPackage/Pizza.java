package PizzaPackage;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private String crust;
    private String sauce;
    private String cheese;
    private List<String> toppings;
    private Size size;
    private double price;

    private Pizza(PizzaBuilder builder) {
        this.name = builder.name;
        this.crust = builder.crust;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.size = builder.size;
        calculatePrice();
    }

    private void calculatePrice() {
        double basePrice = 8.0; // Base price for the pizza
        double toppingPrice = 1.5; // Example price per topping

        // Add the size multiplier
        price = basePrice * size.getPriceMultiplier();

        // Add the price of toppings
        price += toppings.size() * toppingPrice;

        // Optionally add more logic for crust, cheese, or sauce customization
    }

    // Getters
    public String getName() {
        return name;
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

    public List<String> getToppings() {
        return toppings;
    }

    public Size getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    // Builder Pattern Implementation
    public static class PizzaBuilder {

        private String name;
        private String crust;
        private String sauce;
        private String cheese;
        private List<String> toppings = new ArrayList<>();
        private Size size = Size.MEDIUM;

        public PizzaBuilder withName(String name) {
            this.name = name;
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

        public PizzaBuilder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public PizzaBuilder withSize(Size size) {
            this.size = size;
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
