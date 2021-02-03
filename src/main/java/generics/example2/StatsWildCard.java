package generics.example2;

public class StatsWildCard<T extends Number> {
    T[] nums;
    private double sum = 0.0;

    StatsWildCard(T[] nums) {
        this.nums = nums;
    }

    double average() {
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i].doubleValue();
        }
        return sum / nums.length;
    }

    boolean sameAvg(StatsWildCard<? extends Number> ob) {
        if (average() == ob.average()) {
            return true;
        } else {
            return false;
        }
    }

    public static<T> boolean compare(T t1, T t2) {
        if (t1.equals(t2))
            return true;
        else
            return false;
    }

}
