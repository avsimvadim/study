package java8.interfacesFeatures;

public class Circle2 implements Resizable, Position{
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


    //custom changes
    @Override
    public int changeX(int x) {
        setX(x + 1);
        return getX();
    }

    @Override
    public int changeY(int y) {
        setY(y + 1);
        return getY();
    }

    @Override
    public int resize(int percent) {
        int newDiameter = getDiameter() * percent / 100;
        setDiameter(newDiameter + 1);
        return getDiameter();
    }
}
