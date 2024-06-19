package sandbox;

public class ComplexObject implements Cloneable{
    private int number;

    public ComplexObject(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        ComplexObject cloned  = (ComplexObject) super.clone();
        return cloned;
    }
}
