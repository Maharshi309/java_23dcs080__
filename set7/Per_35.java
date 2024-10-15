class IncrementThread extends Thread {
    private int number;

    public IncrementThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            number++;
            System.out.println("Incremented value after 1 second: " + number);
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted");
        }
    }
}

public class Per_35 {
    public static void main(String[] args) {
        int initialValue = 0;
        System.out.println("Initial value: " + initialValue);
        IncrementThread incrementThread = new IncrementThread(initialValue);
        incrementThread.start();
        System.out.println("23DCS080 Maharshi Patel");
    }
}


