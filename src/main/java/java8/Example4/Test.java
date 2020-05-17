package java8.Example4;

import java8.Example1.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 200, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        //process the OptionalInt explicitly to define a default value if there’s no maximum
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCallories)
                .max();
        int max = maxCalories.orElse(1);

        //numeric ranges. range [)exclusive    rangeClosed []inclusive
        IntStream evenNumbers = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());


        //stream from files
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("src/main/java/java8/Example4/data.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
            System.out.println("unique words: " + uniqueWords);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        //creating infinite streams
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        //Fibonacci tuples series
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0]+t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);

        //using int supplier
        IntSupplier fib = new IntSupplier(){
            private int previous = 0;
            private int current = 1;
            public int getAsInt(){
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

        //random generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        //infinite stream of ones
        //IntStream ones = IntStream.generate(() -> 1);
    }
}
