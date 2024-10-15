import java.util.*;

public class  Chocolate{

    public static void front_times(String a, int n)
    {
        for(int i=0;i<n;i++)
        {
            if(a.length()>3)
            System.out.print(a.substring(0,3));
            else
            System.out.print(a.substring(0,a.length()));
        }
    }    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        front_times("Chocolate",3);
        sc.close();
    }
}