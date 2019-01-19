package java8.Flattering;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArraysStream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println(wordLengths);

        words.stream().map(w -> w.split("")).flatMap(Arrays::stream)
                .distinct().forEach(System.out::print);


    }
}
