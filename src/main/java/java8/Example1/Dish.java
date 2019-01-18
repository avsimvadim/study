package java8.Example1;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int callories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int callories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.callories = callories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCallories() {
        return callories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", callories=" + callories +
                ", type=" + type +
                '}';
    }

    public enum Type{
        MEAT,FISH,OTHER
    }
}
