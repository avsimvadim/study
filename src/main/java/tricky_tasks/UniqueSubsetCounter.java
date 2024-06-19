package tricky_tasks;

import java.util.*;

public class UniqueSubsetCounter {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4); // Example list
        int minLength = 2; // Minimum length of subsets
        System.out.println("Number of unique subsets: " + countUniqueSubsets(list, minLength));
    }

    public static int countUniqueSubsets(List<Integer> list, int minLength) {
        Set<Set<Integer>> uniqueSubsets = new HashSet<>();
        generateSubsets(list, 0, new HashSet<>(), uniqueSubsets, minLength);
        return uniqueSubsets.size();
    }

    private static void generateSubsets(List<Integer> list, int index, Set<Integer> current, Set<Set<Integer>> uniqueSubsets, int minLength) {
        if (index == list.size()) {
            if (current.size() >= minLength) {
                uniqueSubsets.add(new HashSet<>(current));
            }
            return;
        }

        // Include the current element
        current.add(list.get(index));
        generateSubsets(list, index + 1, current, uniqueSubsets, minLength);

        // Exclude the current element
        current.remove(list.get(index));
        generateSubsets(list, index + 1, current, uniqueSubsets, minLength);
    }
}
