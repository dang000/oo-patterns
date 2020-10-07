/**
 *  -> Decorator Pattern
 *
 *  1. Create base interface
 *  2. Create decorator interface which implements the base interface
 *  3. Implement the base interface to create a concrete class
 *  4. Implement the decorator interface to create decorator classes;
 *     these return the concrete class + any decorators it adds,
 *     allowing decorators to stack
 *
 */

package DecoratorPattern;

public interface Coffee {
    String getDesc();
    double getCost();
}

interface CoffeeDecorator extends Coffee {
    String getDesc();
    double getCost();
}

class DarkRoast implements Coffee {
    public String getDesc() {
        return "-> Dark Roast";
    }

    public double getCost() {
        return 4.00;
    }
}

class LightRoast implements Coffee {
    public String getDesc() {
        return "-> Light Roast";
    }

    public double getCost() {
        return 4.50;
    }
}

class SkimMilk implements CoffeeDecorator {
    Coffee coffee;

    public SkimMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDesc() {
        return coffee.getDesc() + ", Skim Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1;
    }
}

class FullMilk implements CoffeeDecorator {
    Coffee coffee;

    public FullMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDesc() {
        return coffee.getDesc() + ", Full Cream Milk";
    }

    public double getCost() {
        return coffee.getCost() + 1.25;
    }
}

class Chocolate implements CoffeeDecorator {
    Coffee coffee;

    public Chocolate(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDesc() {
        return coffee.getDesc() + ", Chocolate Topping";
    }

    public double getCost() {
        return coffee.getCost() + 0.25;
    }
}

class Sugar implements CoffeeDecorator {
    Coffee coffee;

    public Sugar(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDesc() {
        return coffee.getDesc() + ", Extra Sugar";
    }

    public double getCost() {
        return coffee.getCost() + 0.10;
    }
}

class Test {
    public static void main(String[] args) {
        Coffee coffee1 = new DarkRoast();
        coffee1 = new FullMilk(new Chocolate(coffee1));

        Coffee coffee2 = new LightRoast();
        coffee2 = new SkimMilk(new Chocolate(new Sugar(new Sugar(coffee2))));

        System.out.println(coffee1.getDesc());
        System.out.println(coffee1.getCost());
        System.out.println(coffee2.getDesc());
        System.out.println(coffee2.getCost());
    }
}
