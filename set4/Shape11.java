interface Shape {

    String getcolor();
    double getarea();

    default void display() {
        System.out.println("THE SHAPE WITH COLOR :" + getcolor());
    }
}

class Circle implements Shape {

    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String getcolor() {
        return color;
    }

    @Override
    public double getarea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("THE CIRCLE WITH COLOR: " + getcolor() + " AND AREA: " + getarea());
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;
    private String color;

    public Rectangle(double length, double width, String color) {
        this.length = length;
        this.width = width;
        this.color = color;
    }

    @Override
    public String getcolor() {
        return color;
    }

    @Override
    public double getarea() {
        return length * width;
    }

    @Override
    public void display() {
        System.out.println("THE RECTANGLE WITH COLOR: " + getcolor() + " AND AREA: " + getarea());
    }
}

class Sign {

    private Shape shape;
    private String text;

    public Sign(Shape shape, String text) {
        this.shape = shape;
        this.text = text;
    }

    public void displaySign() {
        shape.display();
        System.out.println("THE SIGN HAS TEXT: " + text);
    }
}

public class Shape11 {
    public static void main(String[] args) {

        Shape circle = new Circle(5, "Red");
        Shape rectangle = new Rectangle(4, 6, "Blue");

        Sign sign1 = new Sign(circle, "Welcome to Campus Center!");
        Sign sign2 = new Sign(rectangle, "No Smoking Area");

        sign1.displaySign();
        sign2.displaySign();
    }
}
