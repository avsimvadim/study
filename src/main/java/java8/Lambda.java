package java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lambda {
    public static void main(String[] args) {
//        Function<String, Integer> function1 = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) {
//                return s.length() * 2;
//            }
//        };
//
//        Function<String, Integer> function2 = (String s) -> { return s.length() * 2; };
//
//        Function<String, Integer> function3 = s -> s.length() * 2;

        List<String> list = Arrays.asList("acsdvs", "sgdg", "fgfg", "ree","acvs", "bsgdg", "fgbbbbbbbfg", "rfvee");

        List<Integer> result = list.stream().map(s -> s.length() * 2).collect(Collectors.toList());

        for (Integer integer : result) {
            System.out.println(integer);
        }

        //thread
        Runnable runnable = () -> {
            System.out.println();
        };
        Thread thread = new Thread(runnable);
    }
}
