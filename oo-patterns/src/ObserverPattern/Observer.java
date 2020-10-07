/**
 *  -> Observer Pattern
 *
 *  1. Create observer interface
 *  2. Create subject interface with add, remove and notify
 *  3. Implement variations of observers
 *  4. Add listeners externally
 *
 */

package ObserverPattern;

import java.util.ArrayList;

interface Observer {
    void update(Object obj);
}

interface Subject {
    void addListener(Observer obs);
    void removeListener(Observer obs);
    void notifyListeners();
}

class PrintCelsius implements Observer {
    @Override
    public void update(Object obj) {
        if(obj instanceof Weather)
            System.out.println(((Weather) obj).temp + " deg celsius");
    }
}

class PrintFahrenheit implements Observer {
    @Override
    public void update(Object obj) {
        if(obj instanceof Weather)
            System.out.println(((Weather) obj).temp + 20 + " deg fahrenheit");
    }
}

class Weather implements Subject {
    ArrayList<Observer> observers;
    double temp;

    public Weather() {
        this.observers = new ArrayList<>();
        this.temp = 0;
    }

    public void setWeather(double newTemp) {
        this.temp = newTemp;
        this.notifyListeners();
    }

    @Override
    public void addListener(Observer obs) {
        if(!observers.contains(obs))
            observers.add(obs);
    }

    @Override
    public void removeListener(Observer obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyListeners() {
        for(Observer o: observers)
            o.update(this);
    }
}

class Test {
    public static void main(String[] args) {
        Weather weather = new Weather();

        weather.addListener(new PrintCelsius());
        weather.addListener(new PrintFahrenheit());

        weather.setWeather(30);
        weather.setWeather(12);
    }
}