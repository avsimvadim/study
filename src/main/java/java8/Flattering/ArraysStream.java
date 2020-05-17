package java8.Flattering;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ArraysStream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "Action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println(wordLengths);
        
        words.stream().map(w -> w.split("")).flatMap(Arrays::stream)
                .distinct().forEach(System.out::print);

        //make pairs [{1,2},{1,4},{3,2}...]
        System.out.println();
        List<Integer> numbers1 = Arrays.asList(1,3,5);
        List<Integer> numbers2 = Arrays.asList(2,4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i,j})
                ).collect(toList());

        //flat
        System.out.println();
        List<List<String>> list = Arrays.asList(
                Arrays.asList("a","c","f"),
                Arrays.asList("b","g"));
        list
                .stream()
                .flatMap(Collection::stream)
                .forEach(System.out::print);
    }
}
