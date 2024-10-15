import java.util.*;

class SumThread extends Thread {
    private int[] numbers;
    private int start;
    private int end;
    private long partialSum;

    public SumThread(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            partialSum += numbers[i];
        }
    }

    public long getPartialSum() {
        return partialSum;
    }
}

public class Per_33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of N: ");
        int N = scanner.nextInt();
        System.out.print("Enter the number of threads: ");
        int numberOfThreads = scanner.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        SumThread[] threads = new SumThread[numberOfThreads];
        int chunkSize = N / numberOfThreads;
        int remaining = N % numberOfThreads;

        int start = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            int end = start + chunkSize - 1;
            if (i < remaining) {
                end++;
            }

            threads[i] = new SumThread(numbers, start, end);
            threads[i].start();

            start = end + 1;
        }

        long totalSum = 0;
        try {
            for (int i = 0; i < numberOfThreads; i++) {
                threads[i].join();
                totalSum += threads[i].getPartialSum();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The sum of numbers from 1 to " + N + " is: " + totalSum);
        scanner.close();
    }
}
