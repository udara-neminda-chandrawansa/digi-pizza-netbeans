package PaymentsPackage;

import java.awt.Component;
import javax.swing.JOptionPane;

// payment strategy (credit card/paypal)
interface PaymentStrategy {

    void pay(double amount, Component component);
}

class CreditCardPayment implements PaymentStrategy {

    @Override
    public void pay(double amount, Component component) {
        JOptionPane.showMessageDialog(component, "Paid $" + amount + " using Credit Card.",
                "Digi-Pizza | Best Pizzas for you!", JOptionPane.INFORMATION_MESSAGE);
    }
}

class PayPalPayment implements PaymentStrategy {

    @Override
    public void pay(double amount, Component component) {
        JOptionPane.showMessageDialog(component, "Paid $" + amount + " using PayPal.",
                "Digi-Pizza | Best Pizzas for you!", JOptionPane.INFORMATION_MESSAGE);
    }
}
// promotion strategy (for seasonal promotions implementation)
interface PromotionStrategy {

    double applyDiscount(double amount, float percentage);
}

class ApplyPromotion implements PromotionStrategy{
    @Override
    public double applyDiscount(double amount, float percentage) {
        // total amount = amount * percentage that u have to pay after applying discount
        return amount * (percentage / 100);
    }
}