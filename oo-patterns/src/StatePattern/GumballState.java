/**
 *  -> State Pattern
 *
 *  1. Create interface for state functions
 *  2. Create classes for each state
 *  3. Create class that holds state (with initial state)
 *
 */

package StatePattern;

public interface GumballState {
    void printState();
    GumballState insertQuarter();
    GumballState giveGumball();
}

class SoldOutState implements GumballState {
    @Override
    public void printState() {
        System.out.println("No more gumballs");
    }

    @Override
    public GumballState insertQuarter() {
        return this;
    }

    @Override
    public GumballState giveGumball() {
        return this;
    }
}

class NoMoney implements GumballState {
    @Override
    public void printState() {
        System.out.println("Please add money to machine");
    }

    @Override
    public GumballState insertQuarter() {
        return new HasMoney();
    }

    @Override
    public GumballState giveGumball() {
        return this;
    }
}

class HasMoney implements GumballState {
    @Override
    public void printState() {
        System.out.println("Please twist knob for gumballs");
    }

    @Override
    public GumballState insertQuarter() {
        return this;
    }

    @Override
    public GumballState giveGumball() {
        return new NoMoney();
    }
}

class GumballMachine {
    GumballState gumballState;

    public GumballMachine() {
        this.gumballState = new NoMoney();
    }

    public void insertQuarter() {
        gumballState = gumballState.insertQuarter();
        gumballState.printState();
    }

    public void giveGumball() {
        gumballState = gumballState.giveGumball();
        gumballState.printState();
    }
}

class Test {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine();

        gumballMachine.gumballState.printState();
        gumballMachine.insertQuarter();
        gumballMachine.insertQuarter();
        gumballMachine.giveGumball();
    }
}