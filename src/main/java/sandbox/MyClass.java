package sandbox;

public class MyClass implements Cloneable {
    private int age;
    private ComplexObject complexObject;

    public MyClass(int age, ComplexObject complexObject) {
        this.age = age;
        this.complexObject = complexObject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ComplexObject getComplexObject() {
        return complexObject;
    }

    public void setComplexObject(ComplexObject complexObject) {
        this.complexObject = complexObject;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyClass cloned = (MyClass) super.clone();
        cloned.complexObject = (ComplexObject) this.complexObject.clone();
        return cloned;
    }
}

