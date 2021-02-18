package tricky_tasks;

//Given an array arr[] of integers, find out the maximum difference between any two elements
// such that larger element appears after the smaller number.
public class MaxDiff {
    public static void main(String[] args) {
        int arr[] = {7, 9, 5, 6, 3, 2};
        simple(arr);
        complex(arr);
    }

    private static void simple(int arr[]) {
        int diff = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] > diff)
                    diff = arr[j] - arr[i];
            }
        }
        System.out.println(diff);
    }

    private static void complex(int arr[]) {
        int diff = 0;
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > diff)
                diff = arr[i] - min;
            if (arr[i] < min)
                min = arr[i];
        }
        System.out.println(diff);
    }
}
