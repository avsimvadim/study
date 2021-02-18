package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,3,4,5,6,-4,3,45,-343242,5,-5,4,3,45,6,-7,8,76,56,5,4,-43,324};
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                int tmp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = tmp;
                j--;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);

    }
}
