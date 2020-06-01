package java8.interfacesFeatures;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setDiameter(10);
        System.out.println(circle.resize(120));

        circle.setX(10);
        circle.setY(15);

        System.out.println(circle.changeX(20));

        Circle2 circle2 = new Circle2();

        circle2.setDiameter(10);
        System.out.println(circle2.resize(120));

        circle2.setX(10);
        circle2.setY(15);

        System.out.println(circle2.changeX(20));
    }
}
