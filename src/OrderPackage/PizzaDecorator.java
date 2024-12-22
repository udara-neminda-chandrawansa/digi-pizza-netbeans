package OrderPackage;

//
// ** Decorators for extra features (Decorator Pattern implementation)
//
public interface PizzaDecorator{
    String getDescription();
    double getCost();
}

// pizza with no-extra features
class BasicPizza implements PizzaDecorator {
    @Override
    public String getDescription() {
        return "Basic Pizza";
    }

    @Override
    public double getCost() {
        return 0.0;
    }
}

abstract class ExtraFeatures implements PizzaDecorator {
    protected PizzaDecorator decoratedPizza;

    public ExtraFeatures(PizzaDecorator decoratedPizza) {
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedPizza.getCost();
    }
}
// extra packaging feature
class PackagingDecorator extends ExtraFeatures {
    public PackagingDecorator(PizzaDecorator decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Special Packaging";
    }

    @Override
    public double getCost() {
        return super.getCost() + 250.0;
    }
}

// extra toppings feature
class ExtraToppingDecorator extends ExtraFeatures {
    public ExtraToppingDecorator(PizzaDecorator decoratedPizza) {
        super(decoratedPizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Extra Toppings";
    }

    @Override
    public double getCost() {
        return super.getCost() + 350.0;
    }
}