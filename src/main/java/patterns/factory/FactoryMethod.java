package patterns.factory;

import java.util.Date;
// the factory method pattern is a creational pattern that uses factory methods
// to deal with the problem of creating objects without having to specify
// the exact class of the object that will be created.
// This is done by creating objects by calling a factory method
// either specified in an interface and implemented by child classes,
// or implemented in a base class and optionally overridden by derived classes
// rather than by calling a constructor.
public class FactoryMethod {
    public static void main(String[] args) {
        WatchMaker watchMaker = getMakerByName("Digital");
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }

    public static WatchMaker getMakerByName(String maker){
        switch (maker){
            case "Digital":
                return new DigitalWatchMaker();
            case "Rome":
                return new RomeWatchMaker();
            default:
                System.out.println("invalid");
                return null;
        }
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    public void showTime(){
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    public void showTime(){
        System.out.println("X-XV");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    public Watch createWatch(){
        return new RomeWatch();
    }
}