import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PRAC27 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java LineCounter <file1> <file2> ...");
            return;
        }

        for (String filename : args) {
            try {
                int lineCount = countLines(filename);
                System.out.println(filename + ": " + lineCount + " lines");
            } catch (IOException e) {
                System.err.println("Error reading file: " + filename);
            }
        }
    }

    private static int countLines(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
}

