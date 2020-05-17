package java8.LambdaChaining;

import java8.refmethods.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Test {
    public static void main(String[] args) {
        Comparator<Apple> comparator = comparing(apple -> apple.getWeight());
        generateApples().stream().sorted(comparator);

        generateApples().stream().sorted(comparing(apple -> apple.getWeight()));

        generateApples().stream().sorted(comparing(Apple::getWeight));

        //composing comparator
        generateApples().stream().sorted(comparing(Apple::getWeight).reversed());

        generateApples().stream().sorted(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

        //Composing Predicate
        Predicate<Apple> redApple = apple -> apple.getColor().contains("3");

        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> predicate = redApple.and(a -> a.getWeight() > 2);

        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
        List<String> result = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        List<String> result2 = names.stream()
                .filter(name -> name.startsWith("A"))
                .filter(name -> name.length() < 5)
                .collect(Collectors.toList());

        List<String> result3 = names.stream()
                .filter(name -> name.startsWith("A") && name.length() < 5)
                .collect(Collectors.toList());

        Predicate<String> predicate1 =  str -> str.startsWith("A");
        Predicate<String> predicate2 =  str -> str.length() < 5;
        List<String> result4 = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());

        Predicate<String> predicate3 =  str -> str.startsWith("J");
        Predicate<String> predicate4 =  str -> str.length() < 4;
        List<String> result5 = names.stream()
                .filter(predicate3.or(predicate4.negate()))
                .collect(Collectors.toList());

        List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();
        allPredicates.add(str -> str.startsWith("A"));
        allPredicates.add(str -> str.contains("d"));
        allPredicates.add(str -> str.length() > 4);
        List<String> result6 = names.stream()
                .filter(allPredicates.stream().reduce(x->true, Predicate::and))
                .collect(Collectors.toList());

    }

    static List<Apple> generateApples(){
        List<Apple> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add(new Apple(i,String.valueOf(i) + "red"));
        }
        return list;
    }
}
