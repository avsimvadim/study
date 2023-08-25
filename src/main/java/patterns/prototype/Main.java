package patterns.prototype;

// Prototype interface
interface Shape extends Cloneable {
    void draw();
    Shape clone();
}

// Concrete prototypes
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }

    @Override
    public Shape clone() {
        return new Circle();
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public Shape clone() {
        return new Rectangle();
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }

    @Override
    public Shape clone() {
        return new Triangle();
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape clonedCircle = circle.clone();
        clonedCircle.draw();

        Shape rectangle = new Rectangle();
        Shape clonedRectangle = rectangle.clone();
        clonedRectangle.draw();

        Shape triangle = new Triangle();
        Shape clonedTriangle = triangle.clone();
        clonedTriangle.draw();
    }
}
