package tricky_tasks;

import java.util.*;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int n = 3, k = 2;
        combine(result, new ArrayList<>(), 1, n, k);

        System.out.println(result);
    }

    private static void combine(List<List<Integer>> result, List<Integer> subArray, int start, int n, int k) {
        if (subArray.size() == k) {
            result.add(new ArrayList<>(subArray));
            return;
        }

        for (int i = start; i <= n; i++) {
            subArray.add(i);
            combine(result, subArray, i + 1, n, k);
            subArray.remove(subArray.size() - 1);
        }
    }
}
