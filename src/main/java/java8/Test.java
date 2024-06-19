package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<List<Integer>> list = List.of(Arrays.asList(1,2,3),Arrays.asList(4,5,6));
        List<String> numbers1 = Arrays.asList("10","11","20");
        numbers1.stream().mapToDouble(Integer::valueOf).count();
    }
}
