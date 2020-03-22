package generics.example2;

public class Main {
    public static void main(String[] args) {
        Stats<Integer> stats = new Stats<>(new Integer[]{1,3,4,4,4});
        System.out.println(stats.average());


        StatsWildCard<Integer> statsWildCard1 = new StatsWildCard<>(new Integer[]{1,2,3});
        StatsWildCard<Double> statsWildCard2 = new StatsWildCard<>(new Double[]{1.0,2.0,3.0});
        System.out.println(statsWildCard1.sameAvg(statsWildCard2));
    }
}
