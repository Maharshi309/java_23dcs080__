class even extends Thread {
    int n;

    public even(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println(n * n);
    }
}

class odd extends Thread {
    int n;

    public odd(int n) {
        this.n = n;
    }

    public void run() {
        System.out.println(n * n * n);
    }
}

public class Per_34 {
    public static void main(String[] args) {
        even e;
        odd o;

        for (int i = 1; i <= 10; i++) {
            e = new even(i);
            o = new odd(i);
            try {
                if (i % 2 == 0) {
                    e.start();
                } else {
                    o.start();
                }
                Thread.sleep(1000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("23DCS080 Maharshi Patel");
    }
}

