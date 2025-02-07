package Q3.ABCLab;

public class Rectangle extends NotCircle {
    private double width;

    public Rectangle(double h, double w) {
        height = h;
        width = w;
    }

    public double getHeight() { return height; }
    public void setHeight(double h) { height = h; }

    public void calcArea() {
        System.out.println("Area: " + (width * height));
    }

    public void calcPerim() {
        System.out.println("Perimeter: " + (2 * width + 2 * height));
    }
}
