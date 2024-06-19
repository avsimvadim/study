package patterns.observer;

import java.util.ArrayList;
import java.util.List;

public class MeteoApp {
    public static void main(String[] args) {
        MeteoStation meteoStation = new MeteoStation();
        meteoStation.addObserver(new FirstObserver());
        meteoStation.addObserver(new SecondObserver());

        meteoStation.setData(30,730);
        meteoStation.setData(40,720);
    }
}

interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(int temp, int pressure);
}

class MeteoStation implements Observed{
    private List<Observer> observers = new ArrayList<>();
    private int temp;
    private int pressure;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(int temp, int pressure) {
        for(Observer o: observers){
            o.handle(temp,pressure);
        }
    }

    protected void setData(int temp, int pressure){
        this.temp = temp;
        this.pressure = pressure;
        notifyObservers(temp,pressure);
    }
}


interface Observer{
    void handle(int temp, int pressure);
}

class FirstObserver implements Observer{
    @Override
    public void handle(int temp, int pressure) {
        System.out.printf("First Temperature %d, pressure %d\n", temp, pressure );
    }
}

class SecondObserver implements Observer{
    @Override
    public void handle(int temp, int pressure) {
        System.out.printf("SECOND TEMPERATURE %d, PRESSURE %d\n", temp, pressure );
    }
}