package hatchways_tasks;

import java.util.Arrays;

//given [1,2,3,5,6,7,10,25,26,27]
//output ["1-3","5-7","10","25-27"]
public class CombineConsecutiveNumbers {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 6, 7, 10, 25, 26, 27};
        String res[] = new String[arr.length];
        String start = String.valueOf(arr[0]);
        String end;
        int pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length && arr[i + 1] != arr[i] + 1) {
                end = String.valueOf(arr[i]);
                if (start.equals(end))
                    res[pos++] = start;
                else
                    res[pos++] = start + "-" + end;
                start = String.valueOf(arr[i + 1]);
            }
            if (i + 1 == arr.length) {
                end = String.valueOf(arr[i]);
                if (start.equals(end)) {
                    res[pos] = start;
                } else {
                    res[pos] = start + "-" + end;
                }
            }
        }
        int size = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == null) {
                size = i;
                break;
            } else {
                size = i;
            }
        }
        String res2[] = new String[size];
        for (int i = 0; i < res2.length; i++) {
            res2[i] = res[i];
        }
        Arrays.stream(res2).forEach(System.out::println);

    }
}
