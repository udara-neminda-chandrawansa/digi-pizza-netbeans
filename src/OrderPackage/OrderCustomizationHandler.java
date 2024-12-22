package OrderPackage;

//
// ** chain of responsibility pattern implementation (for applying extra features)
//
abstract class OrderCustomizationHandler {
    // handler which is responsible for customizing the order
    protected OrderCustomizationHandler nextHandler;
    // this can set the next customizer in line
    public void setNextCustomizer(OrderCustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    // execution
    public abstract Object[] handleRequest(boolean[] request, PizzaDecorator PD);
}

// Packaging handler
class PackagingCustomization extends OrderCustomizationHandler {

    @Override
    public Object[] handleRequest(boolean[] request, PizzaDecorator PD) {
        if (request[1]) { // Special packaging is at index 1
            PD = new PackagingDecorator(PD); // Apply the packaging customization
            System.out.println("Packaging Customized: " + PD.getDescription());
        }
        // Pass to the next handler if it exists
        if (nextHandler != null) {
            return nextHandler.handleRequest(request, PD);
        }
        // Return the final result
        return new Object[]{PD.getDescription(), PD.getCost()};
    }
}

// Toppings handler
class ToppingsCustomization extends OrderCustomizationHandler {

    @Override
    public Object[] handleRequest(boolean[] request, PizzaDecorator PD) {
        if (request[0]) { // Extra toppings is at index 0
            PD = new ExtraToppingDecorator(PD); // Apply the toppings customization
            System.out.println("Toppings Customized: " + PD.getDescription());
        }
        // Pass to the next handler if it exists
        if (nextHandler != null) {
            return nextHandler.handleRequest(request, PD);
        }
        // Return the final result
        return new Object[]{PD.getDescription(), PD.getCost()};
    }
}
