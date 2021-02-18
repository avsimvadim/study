package tricky_tasks;

import java.util.*;

public class MaxSpan {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1, 1, 3};
        int span = maxSpan(arr);
        System.out.println(span);
    }

    public static int maxSpan(int[] nums) {
        Map<Integer,Integer> first = new HashMap<>();
        int maxSpan = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(first.containsKey(num)){
                maxSpan = Math.max(i - first.get(num) + 1, maxSpan);
            } else {
                first.put(num,i);
                maxSpan = i - first.get(num) + 1 > maxSpan ? 1 : maxSpan;
            }
        }
        return maxSpan;
    }
}
