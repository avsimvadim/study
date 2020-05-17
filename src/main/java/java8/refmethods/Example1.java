package java8.refmethods;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class Example1 {
    public static void main(String[] args) {

        //reference method, instance of an arbitrary type
        List<String> strings = Arrays.asList("b", "v", "sd", "apple", "juice", "f", "y");
        strings.sort((s1,s2) -> s1.compareTo(s2));
        strings.forEach(System.out::print);

        strings.sort(String::compareToIgnoreCase);
        System.out.println();

        BiPredicate<List<String>,String> list2 = (list,s) -> list.contains(s);
        BiPredicate<List<String>,String> list = List::contains;
        list.test(strings,"v");
        System.out.println();

        //reference method, static method
        Function<String,Integer> func = s -> Integer.parseInt(s);
        System.out.println(func.apply("10"));

        Function<String,Integer> func2 = Integer::parseInt;
        System.out.println(func2.apply("10"));

        //reference method, constructor
        Supplier<Apple> sup1 = () -> new Apple();
        Apple apple = sup1.get();
        Supplier<Apple> sup2 = Apple::new;
        Apple apple1 = sup2.get();

        Function<Integer, Apple> func3 = weight -> new Apple(weight);
        Apple apple2 = func3.apply(10);

        Function<Integer, Apple> func4 = Apple::new;
        Apple apple3 = func4.apply(5);

        BiFunction<Integer,String,Apple> biFunction1 = (i,s) -> new Apple(i,s);
        biFunction1.apply(3,"green");

        BiFunction<Integer,String,Apple> biFunction2 = Apple::new;
        biFunction1.apply(2,"red");

        Arrays.asList(1,4,3,3,5,3,8).stream().map(Apple::new).toArray(Apple[]::new);
    }
}
