package java8.Example3;

public class Trader implements Comparable{
    private final String name;
    private final String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader " + this.name + " in " + this.city + "\n";
    }


    @Override
    public int compareTo(Object o) {
        Trader t = (Trader)o;
        return t.getCity().compareTo(this.getCity());
    }
}
