package patterns.builder.example2;

public class CoffeaBuilderApp {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new CostaCoffea());
        Coffea coffea = director.buildCoffea();
        System.out.println(coffea);
    }
}

enum Type{
    ARABICA,ROBUSTA
}

class Coffea{
    private int volume;
    private Type type;
    private boolean sugar;

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return "Coffea{" +
                "volume=" + volume +
                ", type=" + type +
                ", sugar=" + sugar +
                '}';
    }
}

abstract class CoffeaBuilder{
    Coffea coffea;

    void createCoffea(){
        coffea = new Coffea();
    }

    public abstract void setVolume();

    public abstract void setType();

    public abstract void setSugar();

    public Coffea getCoffea(){
        return coffea;
    }
}

class StarBucksCoffea extends CoffeaBuilder{

    @Override
    public void setVolume() {
        coffea.setVolume(350);
    }

    @Override
    public void setType() {
        coffea.setType(Type.ARABICA);
    }

    @Override
    public void setSugar() {
        coffea.setSugar(false);
    }
}

class CostaCoffea extends CoffeaBuilder{

    @Override
    public void setVolume() {
        coffea.setVolume(450);
    }

    @Override
    public void setType() {
        coffea.setType(Type.ROBUSTA);
    }

    @Override
    public void setSugar() {
        coffea.setSugar(true);
    }
}

class Director{
    public CoffeaBuilder coffeaBuilder;

    public void setBuilder(CoffeaBuilder coffeaBuilder){
        this.coffeaBuilder = coffeaBuilder;
    }

    public Coffea buildCoffea(){
        coffeaBuilder.createCoffea();
        coffeaBuilder.setSugar();
        coffeaBuilder.setType();
        coffeaBuilder.setVolume();
        Coffea coffea = coffeaBuilder.getCoffea();
        return coffea;
    }
}
