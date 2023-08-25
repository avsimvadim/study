package patterns.bridge;

import java.util.List;

// Implementor interface
interface DrawingAPI {
    void drawCircle(double x, double y, double radius);
}

// Concrete Implementor: RasterDrawingAPI
class RasterDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing a circle in raster at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Concrete Implementor: VectorDrawingAPI
class VectorDrawingAPI implements DrawingAPI {
    @Override
    public void drawCircle(double x, double y, double radius) {
        System.out.println("Drawing a circle in vector at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Abstraction: Shape
abstract class Shape {
    protected DrawingAPI drawingAPI;

    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }

    abstract void draw();
}

// Refined Abstraction: CircleShape
class CircleShape extends Shape {
    private double x, y, radius;

    public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    void draw() {
        drawingAPI.drawCircle(x, y, radius);
    }
}

public class Main {
    public static void main(String[] args) {
        DrawingAPI rasterAPI = new RasterDrawingAPI();
        Shape rasterCircle = new CircleShape(5, 10, 15, rasterAPI);
        rasterCircle.draw();

        DrawingAPI vectorAPI = new VectorDrawingAPI();
        Shape vectorCircle = new CircleShape(20, 30, 25, vectorAPI);
        vectorCircle.draw();
    }
}
