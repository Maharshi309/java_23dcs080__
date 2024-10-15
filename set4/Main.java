//per == 17
class Parent {
   
    void displayParent() {
        System.out.println("This is parent class");
    }
}

class Child extends Parent {
   
    void displayChild() {
        System.out.println("This is child class");
    }
}


public class Main {
    public static void main(String[] args) {
       
        Parent parentObject = new Parent();
      
        parentObject.displayParent();
        
        
        Child childObject = new Child();
       
        childObject.displayChild();

        System.out.println("23DCS080 Maharshi Patel ");
    }
}
