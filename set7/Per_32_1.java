// Extending the Thread class
class Per_32_1 extends Thread {
    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        
      Per_32_1 thread = new Per_32_1();
        
        thread.start();
        System.out.println("23DCS080 Maharshi Patel");
    }
}
