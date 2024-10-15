class Rectangle {
    double length, breadth;

    // Constructor
    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to print area
    void printArea() {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    // Method to print perimeter
    void printPerimeter() {
        System.out.println("Perimeter of Rectangle: " + 2 * (length + breadth));
    }
}

// Class Square inheriting Rectangle
class Square extends Rectangle {
    // Constructor
    Square(double side) {
        super(side, side);
    }
}
public class Rectangle1 {
    public static void main(String[] args) {
        // Array of objects
        Rectangle[] rectangles = new Rectangle[2];

        // Creating objects
        rectangles[0] = new Rectangle(5, 10);
        rectangles[1] = new Square(5);

        // Printing area and perimeter
        for (Rectangle rectangle : rectangles) {
            rectangle.printArea();
            rectangle.printPerimeter();
            System.out.println();
System.out.println("23DCS080 Maharshi Patel ");

        }
    }
}
