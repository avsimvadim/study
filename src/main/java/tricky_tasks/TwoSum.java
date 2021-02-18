package tricky_tasks;

import java.util.*;

//Write a function that returns true if a pair of integers in the input array adds up to a certain target.
// For example, if the array is [3, 5, 2, -4, 8, 11] and the target is 7, your program should return true
// since 11 + -4 = 7.
// If the array is [2, 8, 4] and the target is 4, the program should return false,
// since no two numbers in the array add up to 4.
public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {3, 5, 2, -4, 8, 11, 0, 7};
        int target = 7;
        simple(arr,target);
        hashMapSolution(arr,target);
        List<Integer> o = new ArrayList<>();
        int arr2[][] = new int[10][10];
    }

    //O(n^2)
    private static void simple(int arr[], int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] + arr[i] == target){
                    System.out.printf("%d+%d=7\n",arr[j],arr[i]);
                    break;
                }
            }
        }
    }

    //O(n)
    public static void hashMapSolution(int[] input, int sum) {
        Set<Integer> elements = new HashSet<>();
        for (int el:
             input) {
            if(elements.contains(sum - el)){
                System.out.printf("%d+%d=7\n",sum - el,el);
            }
            elements.add(el);
        }
    }
}
