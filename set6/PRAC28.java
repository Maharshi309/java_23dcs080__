import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PRAC28 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CharacterCounter <filename> <character>");
            return;
        }

        String filename = args[0];
        char targetChar = args[1].charAt(0); 

        try {
            int charCount = countCharacterOccurrences(filename, targetChar);
            System.out.println("Occurrences of '" + targetChar + "' in " + filename + ": " + charCount);
        } catch (IOException e) {
            System.err.println("Error reading file: " + filename);
        }
    }

    private static int countCharacterOccurrences(String filename, char targetChar) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int count = 0;
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                if (currentChar == targetChar) {
                    count++;
                }
            }
            return count;
        }
    }
}
