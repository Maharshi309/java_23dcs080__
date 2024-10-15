import java.util.*;
interface AdvancedArithmetic {
    int divisor_sum(int n);
    
}

    

class calledMyCalculator implements AdvancedArithmetic{
    public int divisor_sum(int n){
        int sum=0;
        int sqrt =(int) Math.sqrt(n);
        for(int i=1;i<=sqrt;i++){
            if(n%i==0){
                sum+=i;
                if(i!=n/i){
                    sum +=n/i;
                }
            }
        } 
        return sum;
    }
}

class Per_22{
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[]){
     calledMyCalculator cmc=new calledMyCalculator();
     System.out.println("enter the Number:");
     int x=sc.nextInt();

     System.out.println("sum:"+cmc.divisor_sum(x));
     System.out.println("23DCS080 Maharshi Patel ");
    }
    }

