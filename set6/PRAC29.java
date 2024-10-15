import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PRAC29 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java WordSearch <filename> <word>");
            return;
        }

        String filename = args[0];
        String targetWord = args[1];

        try {
            boolean found = searchWord(filename, targetWord);
            if (found) {
                System.out.println("Word '" + targetWord + "' found in " + filename);
            } else {
                System.out.println("Word '" + targetWord + "' not found in " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
        }
    }

    private static boolean searchWord(String filename, String targetWord) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(targetWord)) {
                    return true;
                }
            }
            return false;
        }
    }
}
