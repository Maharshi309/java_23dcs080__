
class D1{
    void getD1(){
        System.out.println("I got a Degree.");
    }
}
class UG extends D1{
    void getD1(){
        System.out.println("I am an Undergraduate.");
    }    
}
class PG extends D1{
    void getD1(){
        System.out.println("I am a Postgraduate.");
    }
}
public class Per_21 {
    public static void main(String[] args) {
        D1 D=new D1();
         UG A=new UG();
         PG B=new PG();

        D.getD1();
        A.getD1();
        B.getD1();
        System.out.println("23DCS080 Maharshi Patel ");
    }
}

