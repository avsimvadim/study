package java8.collectionApi;

import java8.Example1.Dish;
import java8.Example3.Trader;
import java8.Example3.Transaction;

import java.util.*;

import static java.util.Map.*;

public class Example1 {
    public static void main(String[] args) {

        // List factory
        //the list that’s produced is immutable
        List<String> friends = List.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends);

        //Set factory
        //also immutable
        Set<String> friends2 = Set.of("Raphael", "Olivia", "Thibaut");
        System.out.println(friends2);

        //Map factories,  immutable map
        Map<String, Integer> ageOfFriends = Map.of("Raphael", 30, "Olivia", 25);
        System.out.println(ageOfFriends);

        //second way
        Map<String, Integer> ageOfFriends2 = Map.ofEntries(
                entry("Raphael", 30),
                entry("Olivia", 25),
                entry("Thibaut", 26));
        System.out.println(ageOfFriends);


        List<Dish> menuDemo = Arrays.asList(
                new Dish("pork", false, 200, Dish.Type.MEAT),
                new Dish("beef", false, 800, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
        List<Dish> menu = new ArrayList(menuDemo);

        //removeIf
        menu.removeIf(d -> !d.isVegetarian());

        //replaceAll
        menu.replaceAll(d -> new Dish(d.getName(),true,0,d.getType()));

        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        Map<Trader, Transaction> transactionsDemo =Map.of(
                brian, new Transaction(brian,2011,300),
                raoul, new Transaction(raoul,2012,1000),
                mario, new Transaction(mario,2012,710),
                alan, new Transaction(alan,2012,950)
        );
        Map<Trader, Transaction> transactions = new HashMap<>(transactionsDemo);

        //Working with Map foreach
        transactions.forEach((trader, transaction) ->
                System.out.println(trader.getName() + " " + transaction.getValue()));


        Map<String, String> favouriteMovies = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia", "James Bond"));

        //sorting
        favouriteMovies
                .entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .forEachOrdered(System.out::println);


    }
}
