package java8.training;

import java.util.*;
import java.util.stream.*;

public class Training1 {

    public static void main(String[] args) {
        // Example 1: Filtering even numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> userResult1 = filterEvenNumbers(numbers1);
        List<Integer> expectedResult1 = Arrays.asList(2, 4);
        checkResult(userResult1, expectedResult1);

        // Example 2: Mapping numbers to their squares
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> userResult2 = mapToSquares(numbers2);
        List<Integer> expectedResult2 = Arrays.asList(1, 4, 9, 16, 25);
        checkResult(userResult2, expectedResult2);

        // Example 3: FlatMapping lists of lists
        List<List<Integer>> numbers3 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5)
        );
        List<Integer> userResult3 = flatMapLists(numbers3);
        List<Integer> expectedResult3 = Arrays.asList(1, 2, 3, 4, 5);
        checkResult(userResult3, expectedResult3);
    }

    // Implement this method to filter even numbers
    public static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    // Implement this method to map numbers to their squares
    public static List<Integer> mapToSquares(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number).collect(Collectors.toList());
    }

    // Implement this method to flatMap lists of lists
    public static List<Integer> flatMapLists(List<List<Integer>> lists) {
        return lists.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
    }

    // Utility method to check results
    private static void checkResult(List<Integer> userResult, List<Integer> expectedResult) {
        if (userResult.equals(expectedResult)) {
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. Expected: " + expectedResult + " but got: " + userResult);
        }
    }
}