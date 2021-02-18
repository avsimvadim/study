package tricky_tasks;

import java.util.stream.IntStream;

//program that prints the numbers from 1 to 100. 
// But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. 
// For numbers which are multiples of both three and five print “FizzBuzz"
public class FizzBuzzTest {
    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 101).toArray();
        System.out.println(arr[99]);
        for (int i = 1; i < 100; i++) {
            if(arr[i] % 3 == 0 && arr[i] % 5 == 0)
                System.out.println("FizzBuzz");
            else if (arr[i] % 3 == 0)
                System.out.println("Fizz");
            else if (arr[i] % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }
}
