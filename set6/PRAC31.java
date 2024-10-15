import java.io.*;

public class PRAC31 {
    public static void main(String[] args) {
        String filePath = "output.txt";

        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath))) {

            System.out.println("Enter text (type 'exit' to quit):");

            String line;
            while (!(line = consoleReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line);
                fileWriter.newLine();
            }

            System.out.println("Data written to file successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        try (FileInputStream fis = new FileInputStream(filePath);
             FileOutputStream fos = new FileOutputStream("byte_output.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File copied using byte stream successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
