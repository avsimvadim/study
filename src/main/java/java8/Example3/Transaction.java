package java8.Example3;

public class Transaction implements Comparable{
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{" + this.trader +
                ", year=" + this.year +
                ", value=" + this.value +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Transaction t = (Transaction)o;
        return t.getValue() - this.getValue();
    }
}
