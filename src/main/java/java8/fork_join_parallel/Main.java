package java8.fork_join_parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Main {
    public static void main(String[] args) {
        int n = 1000000;
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        Long res = new ForkJoinPool().invoke(task);
        System.out.println(res.intValue());
    }
}
