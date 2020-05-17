package java8.Example5;

import java8.Example1.Dish;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Grouping {
    enum CaloricLevel{DIET,NORMAL,FAT};

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

        //count number of dishes
        long howManyDishes = menu.stream().collect(counting());
        long howManyDishes2 = menu.stream().count();

        //find the highest-calorie dish in the menu
        Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(comparing(Dish::getCallories)));

        //total number of calories in your menu list
        int totalCalories = menu.stream().collect(summingInt(Dish::getCallories));

        //average
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCallories));

        //concatenate the names of all the dishes in the menu
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        String shortMenu2 = menu.stream().map(Dish::getName).collect(joining(", "));

        //Generalized summarization with reduction
        int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCallories, Integer::sum));

        //highest-calorie dish using the one-argument version of reducing
        Optional<Dish> mostCalorieDish2 = menu.stream().
                collect(reducing((d1, d2) -> d1.getCallories() > d2.getCallories() ? d1 : d2));


        //put the ones containing meat in a group, the ones with fish in another group,
        // and all others in a third group
        Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));

        //filter only the caloric dishes
        Map<Dish.Type, List<Dish>> caloricDishesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCallories() > 500, toList())));

        //convert each Dish in the groups into their respective names
        Map<Dish.Type, List<String>> dishNamesByType =
                menu.stream().collect(groupingBy(Dish::getType,
                                mapping(Dish::getName, toList())));


        //Multilevel grouping
        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishesByTypeCaloricLevel =
                menu.stream().collect(
                        groupingBy(Dish::getType,
                                groupingBy(dish -> {
                                    if (dish.getCallories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCallories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                } )
                        )
                );

        Map<Dish.Type, Long> typesCount = menu.stream().collect(
                groupingBy(Dish::getType, counting()));

        Map<Dish.Type, Optional<Dish>> mostCaloricByType =
                menu.stream()
                        .collect(groupingBy(Dish::getType,
                                maxBy(comparingInt(Dish::getCallories))));

        Map<Dish.Type, Dish> mostCaloricByType2 =
                menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(
                        maxBy(comparingInt(Dish::getCallories)), Optional::get)));

        //Partitioning
        Map<Boolean, List<Dish>> partitionedMenu =
                menu.stream().collect(partitioningBy(Dish::isVegetarian));

        menu.stream().collect(partitioningBy(Dish::isVegetarian,
                counting()));

        //wrap another collector and apply a transformation function to its result
        int howManyDishes3 = menu.stream().collect(collectingAndThen(toList(),List::size));



    }


}
