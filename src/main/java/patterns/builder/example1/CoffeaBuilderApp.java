package patterns.builder.example1;

public class CoffeaBuilderApp {
    public static void main(String[] args) {
        Coffea c = new CoffeaBuilder().setSugar(false).setType(Type.ROBUSTA).build();
        System.out.println(c);
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

class CoffeaBuilder{
    private int volume = 250;
    private Type type = Type.ARABICA;
    private boolean sugar = false;

    public CoffeaBuilder setVolume(int volume){
        this.volume = volume;
        return this;
    }

    public CoffeaBuilder setType(Type type){
        this.type = type;
        return this;
    }

    public CoffeaBuilder setSugar(boolean sugar){
        this.sugar = sugar;
        return this;
    }

    public Coffea build(){
        Coffea c = new Coffea();
        c.setVolume(volume);
        c.setType(type);
        c.setSugar(sugar);
        return c;
    }
}
