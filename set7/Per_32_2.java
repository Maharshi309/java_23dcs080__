
class Per_32_2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        
        Per_32_2 helloWorld = new Per_32_2();
    
        Thread thread = new Thread(helloWorld);
        
        thread.start();
        System.out.println("23DCS080 Maharshi Patel");
    }
}
