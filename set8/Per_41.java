import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Per_41 {
    public static void main(String[] args) {
        String filePath = "YourJavaFile.java";
        HashSet<String> keywords = new HashSet<>();
        String[] javaKeywords = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", 
            "class", "const", "continue", "default", "do", "double", "else", "enum", 
            "extends", "final", "finally", "float", "for", "goto", "if", "implements", 
            "import", "instanceof", "int", "interface", "long", "native", "new", 
            "null", "package", "private", "protected", "public", "return", "short", 
            "static", "strictfp", "super", "switch", "synchronized", "this", 
            "throw", "throws", "transient", "try", "void", "volatile", "while"
        };

        for (String keyword : javaKeywords) {
            keywords.add(keyword);
        }

        int keywordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (keywords.contains(word)) {
                        keywordCount++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Number of keywords: " + keywordCount);
    }
}
