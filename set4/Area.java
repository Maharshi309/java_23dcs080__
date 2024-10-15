class Rectangle{

    protected double length  ;
    protected double breadth  ;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void printArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    public void printPerimeter() {
        double perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }
}


    class Square extends Rectangle1 {

        public Square(double side) {
            
       super(side , side);

    
        }

    }
public class Area {
    public static void main(String[] args) {
        Rectangle1 r = new Rectangle1(15, 20);
        r.printArea();
        r.printPerimeter();
        Square s = new Square(10);
        s.printArea();
        s.printPerimeter();
    }
    
}
