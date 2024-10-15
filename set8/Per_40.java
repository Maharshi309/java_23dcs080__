import java.util.*;

public class Per_40 {

    public static void main(String[] args) {
        String text = "This is a sample text. This text is for counting words. Counting words is fun.";
        text = text.replaceAll("[^a-zA-Z ]", "").toLowerCase();
        String[] words = text.split("\\s+");
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        Set<String> uniqueWords = new TreeSet<>(wordCountMap.keySet());
        System.out.println("Word Count:");
        for (String word : uniqueWords) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }
}
