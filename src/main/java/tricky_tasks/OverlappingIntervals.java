package tricky_tasks;


//given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }
// The intervals {1,3} and {2,4} overlap with each other,
// so they should be merged and become {1, 4}.
// Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
public class OverlappingIntervals {
    public static void main(String[] args) {
        int arr[][] = {{1, 3}, {2, 4}, {5, 7}, {6, 8}, {7,9}, {9,12}};
        bruteForceSolution(arr); // O(n^2)
    }

    private static void bruteForceSolution(int arr[][]) {
        int tmp[][] = new int[arr.length][2];
        int len = tmp.length;

        for (int j = 0; j < len; j++) {
            int counter = 0;
            for (int i = 0; i < len; i++) {
                if (i + 1 < len && arr[i][1] - 1 == arr[i + 1][0]) {
                    tmp[counter][0] = arr[i][0];
                    tmp[counter++][1] = arr[i + 1][1];
                    i++;
                } else {
                    tmp[counter][0] = arr[i][0];
                    tmp[counter++][1] = arr[i][1];
                }
            }
            int res[][] = new int[counter][2];
            for (int i = 0; i < res.length; i++) {
                res[i][0] = tmp[i][0];
                res[i][1] = tmp[i][1];
            }
            len = res.length;
            arr = res;
        }
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            if (i !=  arr.length - 1)
                System.out.printf("{%d,%d},", arr[i][0], arr[i][1]);
            else
                System.out.printf("{%d,%d}", arr[i][0], arr[i][1]);
        }
        System.out.print("}");
    }

}
