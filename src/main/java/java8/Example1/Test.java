package java8.Example1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class Test {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );

        List<String> threehighCaloricDishNames = menu.stream()
                .filter(dish -> dish.getCallories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
        System.out.println(threehighCaloricDishNames);

        List<String> names = menu.stream()
                .filter(dish -> {
                                    System.out.println("filtering " + dish.getName());
                                    return dish.getCallories() >  300;
                                })
                .map(dish -> {
                                System.out.println("mapping " + dish.getName());
                                return dish.getName();
                            })
                .limit(3)
                .collect(toList());

        menu.stream().map(dish -> {return dish.getName() + " ";}).forEach(System.out::print);

        menu.stream()
                .filter(d -> d.getCallories() > 300)
                .map(Dish::getName)
                .skip(2)
                .forEach(System.out::println);


        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }


        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));


    }
}
