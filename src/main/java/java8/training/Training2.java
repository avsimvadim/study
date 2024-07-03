package java8.training;

import java.util.*;
import java.util.stream.*;

public class Training2 {

    public static void main(String[] args) {
        // Task 1: Filter and sort names
        List<String> names = Arrays.asList("John", "Jane", "Tom", "Jerry", "Alice", "Bob");
        List<String> userResult1 = filterAndSortNames(names);
        List<String> expectedResult1 = Arrays.asList("Jane", "Jerry", "John");
        checkResult(userResult1, expectedResult1, "Task 1");

        // Task 2: Find the first even number greater than 10
        List<Integer> numbers = Arrays.asList(3, 7, 12, 5, 8, 20);
        Optional<Integer> userResult2 = findFirstEvenNumberGreaterThanTen(numbers);
        Optional<Integer> expectedResult2 = Optional.of(12);
        checkResult(userResult2, expectedResult2, "Task 2");

        // Task 3: Group strings by their length
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        Map<Integer, List<String>> userResult3 = groupStringsByLength(words);
        Map<Integer, List<String>> expectedResult3 = new HashMap<>();
        expectedResult3.put(5, Arrays.asList("apple", "grape"));
        expectedResult3.put(6, Arrays.asList("banana", "cherry"));
        expectedResult3.put(4, Arrays.asList("date"));
        expectedResult3.put(3, Arrays.asList("fig"));
        checkResult(userResult3, expectedResult3, "Task 3");

        // Task 4: Calculate the sum of squares of odd numbers
        List<Integer> moreNumbers = Arrays.asList(1, 2, 3, 4, 5);
        int userResult4 = sumOfSquaresOfOddNumbers(moreNumbers);
        int expectedResult4 = 35; // 1*1 + 3*3 + 5*5
        checkResult(userResult4, expectedResult4, "Task 4");
    }

    // Task 1: Implement this method to filter names that start with "J" and sort them alphabetically
    public static List<String> filterAndSortNames(List<String> list) {
        return list.stream()
                .filter(name -> name.charAt(0) == 'J')
                .sorted()
                .collect(Collectors.toList());
    }

    // Task 2: Implement this method to find the first even number greater than 10
    public static Optional<Integer> findFirstEvenNumberGreaterThanTen(List<Integer> list) {
        return list.stream()
                .filter(number -> number % 2 == 0 && number > 10)
                .findFirst();
    }

    // Task 3: Implement this method to group strings by their length
    public static Map<Integer, List<String>> groupStringsByLength(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(s -> s.length()));
    }

    // Task 4: Implement this method to calculate the sum of squares of odd numbers
    public static int sumOfSquaresOfOddNumbers(List<Integer> list) {
        return list.stream()
                .filter(number -> number % 2 == 1)
                .mapToInt(number -> number * number)
                .reduce(0, (a, b) -> a + b);
    }

    // Utility method to check results for List<String>
    private static void checkResult(List<String> userResult, List<String> expectedResult, String taskName) {
        if (userResult.equals(expectedResult)) {
            System.out.println(taskName + ": Correct!");
        } else {
            System.out.println(taskName + ": Incorrect. Expected: " + expectedResult + " but got: " + userResult);
        }
    }

    // Utility method to check results for Optional<Integer>
    private static void checkResult(Optional<Integer> userResult, Optional<Integer> expectedResult, String taskName) {
        if (userResult.equals(expectedResult)) {
            System.out.println(taskName + ": Correct!");
        } else {
            System.out.println(taskName + ": Incorrect. Expected: " + expectedResult + " but got: " + userResult);
        }
    }

    // Utility method to check results for Map<Integer, List<String>>
    private static void checkResult(Map<Integer, List<String>> userResult, Map<Integer, List<String>> expectedResult, String taskName) {
        if (userResult.equals(expectedResult)) {
            System.out.println(taskName + ": Correct!");
        } else {
            System.out.println(taskName + ": Incorrect. Expected: " + expectedResult + " but got: " + userResult);
        }
    }

    // Utility method to check results for int
    private static void checkResult(int userResult, int expectedResult, String taskName) {
        if (userResult == expectedResult) {
            System.out.println(taskName + ": Correct!");
        } else {
            System.out.println(taskName + ": Incorrect. Expected: " + expectedResult + " but got: " + userResult);
        }
    }
}