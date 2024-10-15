public class YourJavaFile {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println("Count of even numbers: " + count);
        
        if (count > 5) {
            System.out.println("More than 5 even numbers found.");
        } else {
            System.out.println("5 or fewer even numbers found.");
        }
        
        // Using a method
        YourJavaFile example = new YourJavaFile();
        example.printMessage();
    }

    public void printMessage() {
        System.out.println("Hello, this is an example of Java keywords.");
    }
}
