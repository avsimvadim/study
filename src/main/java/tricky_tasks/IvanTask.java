package tricky_tasks;

import java.util.*;
import java.util.stream.Collectors;

public class IvanTask {
    public static void main(String[] args) {
        String input = "Red cat is angry, crazy. Red cat is also sad!";
        //return the first word with no duplicates in the sentence
        //if the word is appended with period

        Arrays.stream(returnFirstUniqueWord(input)).forEach(System.out::println);
    }

    private static String[] returnFirstUniqueWord(String input){
        String[] allWords = input.split(" ");

        Map<String, Integer> wordNumbers = new HashMap<>();

        for (String word : allWords) {
            word = word.toLowerCase().replaceAll("[^a-z]", "");
            wordNumbers.put(word, wordNumbers.getOrDefault(word, 0) + 1);
        }

        Set<String> uniqueWords = wordNumbers.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        String[] sentences = input.split("[.!?]");
        for (String sentence : sentences) {
            String[] words = sentence.split(" ");
            for (int j = 0; j < words.length; j++) {
                String modifiedWord = words[j].toLowerCase().replaceAll("[^a-z]", "");
                if (uniqueWords.contains(modifiedWord)) {
                    return new String[]{words[j], String.valueOf(j)};
                }
            }
        }
        return new String[]{null, "-1"};
    }
}
