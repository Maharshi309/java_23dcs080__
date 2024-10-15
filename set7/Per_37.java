class Produce extends Thread {
    int n;
    boolean produced = false;

    Produce(int n) {
        this.n = n;
    }

    public synchronized void run() {
        for (int i = 1; i <= n; i++) {
            while (produced) {  // Wait if something is already produced
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Produced: " + i);
            produced = true;
            notify();  // Notify the consumer that production is done
        }
    }
}

class Consume extends Thread {
    int n;
    Produce producer;

    Consume(int n, Produce producer) {
        this.n = n;
        this.producer = producer;
    }
 public synchronized void run() {
        for (int i = 1; i <= n; i++) {
            synchronized (producer) {
                while (!producer.produced) {  // Wait until something is produced
                    try {
                        producer.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("Consumed: " + i);
                producer.produced = false;
                producer.notify();  // Notify the producer to produce more
            }
        }
    }
}
public class Per_37 {
    public static void main(String[] args) {
        int n = 10;
Produce p = new Produce(n);
        Consume c = new Consume(n, p);
 p.start();
        c.start();

        System.out.println("23DCS080 Maharshi Patel");
    }
}
