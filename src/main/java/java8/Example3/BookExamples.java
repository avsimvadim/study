package java8.Example3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BookExamples {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul","Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        //find all transactions in the year 2011 and sort them by value(small to high)
        transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::print);
        System.out.println();

        //all the unique cities where the traders work
        transactions.stream().map(transaction -> transaction.getTrader().getCity())
                .distinct().forEach(System.out::print);
        System.out.println();

        //find all traders from Cambridge and sort them by name
        transactions.stream().map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::print);;
        System.out.println();

        //return a string of all traders' names sorted alphabetically
        String s = transactions.stream().map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted()
                .reduce((s1,s2)-> s1 + s2)
                .get();
        System.out.println(s);

        //are any traders based in milan?
        boolean milan = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(milan);

        //print all transactions' values from the traders living in Cambridge
        transactions.stream()
                .filter(t->t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::print);

        //what is the highest value of all the transactions
        int max = transactions.stream()
                .map(t->t.getValue())
                .reduce(Integer::max)
                .get();
        System.out.println(max);

        //find the transaction with the smallest value
        Transaction min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).get();
        System.out.println(min);
    }
}
