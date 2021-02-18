package tricky_tasks;

//NxN grid of integers
//        3 1 1
//        1 1 2
//        1 1 4
//        query(0, 0, 1, 1) -> 6
//        query(1, 1, 2, 2) -> 8
//        query(0, 1, 2, 1) -> 3
//
//        update(1, 1, 7)
//        3 1 1
//        1 7 2
//        1 1 4

public class ArrayRectElemSum {
    public static void main(String[] args) {
        System.out.println(querySimple(1, 1, 2, 2));
    }

    private static int[][] grid = {{3, 1, 1}, {1, 1, 2}, {1, 1, 4}};

    //O(n^2)
    public static int querySimple(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for (int i = x1; i < x2 + 1; i++) {
            for (int j = y1; j < y2 + 1; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    //O(n)
    public static int queryHard(int x1, int y1, int x2, int y2) {
        return 0;
    }

    public static void update(int x, int y, int v) {
        grid[x][y] = v;
    }

}
