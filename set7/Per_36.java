class FirstThread extends Thread {
    public FirstThread() {
        super("FIRST");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }
}

class SecondThread extends Thread {
    public SecondThread() {
        super("SECOND");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }
}

class ThirdThread extends Thread {
    public ThirdThread() {
        super("THIRD");
    }

    @Override
    public void run() {
        System.out.println(getName() + " is running with priority " + getPriority());
    }
}

public class Per_36 {
    public static void main(String[] args) {
        // Creating instances of the threads
        FirstThread firstThread = new FirstThread();
        SecondThread secondThread = new SecondThread();
        ThirdThread thirdThread = new ThirdThread();

        // Setting thread priorities
        firstThread.setPriority(3);  // Priority for 'FIRST'
        // No need to set priority for 'SECOND', it defaults to 5
        thirdThread.setPriority(7);  // Priority for 'THIRD'

        // Starting the threads
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        System.out.println("23DCS080 Maharshi Patel");
        
    }
}
