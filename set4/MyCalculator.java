import java.util.*;
interface AdvancedArithmetic {
    
    int divisor_sum(int n);
}

// Implement the interface in the MyCalculator class
class MyCalculator implements AdvancedArithmetic {

    
    @Override
    public int divisor_sum(int n) {
        int sum = 0;
        
    
        for (int i = 1; i <= n; i++) {
        
            if (n % i == 0) {
                sum += i;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        int n;
        System.out.print("enter the value of n:");
        n=sc.nextInt();


        
        MyCalculator myCalculator = new MyCalculator();
        
        System.out.println("The sum of divisors of " + n + " is: " + myCalculator.divisor_sum(n));
        System.out.println("23DCS080 Maharshi Patel");
    }
}
