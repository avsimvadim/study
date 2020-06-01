package java8.interfacesFeatures;

public class Circle implements Resizable, Position{
    private int diameter;
    private int x;
    private int y;

    @Override
    public int getDiameter() {
        return diameter;
    }

    @Override
    public void setDiameter(int d) {
        diameter = d;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
