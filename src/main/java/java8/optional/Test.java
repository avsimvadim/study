package java8.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5, 30);
        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0)
                .findAny();
        System.out.println(firstSquareDivisibleByThree);
    }
}
