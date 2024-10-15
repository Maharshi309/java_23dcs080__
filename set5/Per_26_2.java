public class Per_26_2 {

   
    public static void checkedExceptionExample() throws java.io.IOException {
  
        throw new java.io.IOException("IO Exception occurred");
    }

   
    public static void uncheckedExceptionExample() {
        
        int result = 10 / 0;
    }

    public static void main(String[] args) {
        
        try {
            checkedExceptionExample();  
        } catch (java.io.IOException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        try {
            Class.forName("NonExistentClass");  
        } catch (ClassNotFoundException e) {
            System.out.println("Caught checked exception: " + e.getMessage());
        }

        
        try {
            uncheckedExceptionExample();  // ArithmeticException (unchecked)
        } catch (ArithmeticException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);  // ArrayIndexOutOfBoundsException (unchecked)
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught unchecked exception: " + e.getMessage());
        }

        System.out.println("Program ends after exception handling.");
    }
}
