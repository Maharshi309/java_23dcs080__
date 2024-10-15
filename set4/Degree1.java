 class Degree {
    public void Getdegree(){
        System.out.println("i got the degree");
    
    }
}

    class Undergraduate extends Degree{
        @Override
        public void Getdegree(){
            System.out.println("i am in undergraduate ");
    }  
}

class Postgraduate extends Degree{

    @Override
    public void Getdegree(){
        System.out.println("I am a Postgraduate");
    }
}

public class Degree1 {

    public static void main(String[] args) {

        Degree obj1 = new Degree();
        obj1.Getdegree();

        Undergraduate obj2 = new Undergraduate();
        obj2.Getdegree();

        Postgraduate obj3 = new Postgraduate();
        obj3.Getdegree();

        System.out.println("23DCS080 Maharshi Patel");


    }
}
 
