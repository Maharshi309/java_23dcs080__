import java.util.*;
class Expense{
public static void main(String args[]){
int day[]=new int[30];
Scanner sc=new Scanner(System.in);
int sum=0;
for(int i=0;i<5;i++){
System.out.print("Day"+(i+1)+":");
int a=sc.nextInt();
sum+=a;
}
System.out.println("total Expenses:"+sum);
System.out.println("23DCS080 Maharshi Patel ");
}
}
