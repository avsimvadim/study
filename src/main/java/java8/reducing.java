package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class reducing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,3,5,6,4,5,6);
        int sum1 = numbers.stream().reduce(1, (a, b) -> a + b);
        System.out.println(sum1);

        int sum2 = numbers.stream().reduce(9, Integer::sum);
        System.out.println(sum2);

        Optional<Integer> sum3 = numbers.stream().reduce(Integer::sum);
        System.out.println(sum3.get());

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min.get());

    }
}
