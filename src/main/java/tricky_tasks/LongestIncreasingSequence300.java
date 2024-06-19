package tricky_tasks;

import java.util.*;

public class LongestIncreasingSequence300 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,2,3};
//        int[] lisLength = new int[nums.length];
//        Arrays.fill(lisLength, 1);
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
//                }
//            }
//        }

        int[] lisLength = new int[nums.length];
        Arrays.fill(lisLength, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lisLength[i] = Math.max(lisLength[i], lisLength[j] + 1);
                }
            }
        }

        int max = Arrays.stream(lisLength).max().orElse(0);
        System.out.println(max);
    }
}
