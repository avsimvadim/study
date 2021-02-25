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
//
//      integrated table
//      3  4  5
//      4  9  16
//      5  15  35

public class ArrayRectElemSum {
    public static void main(String[] args) {
        System.out.println(querySimple(1, 1, 2, 2));
        System.out.println(queryHard(1, 1, 2, 2));

        int[][] ints = integratedTable(grid);
        for (int i = 0; i < ints[0].length; i++) {
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static int[][] grid = {{31, 2, 4}, {12, 26, 9}, {13, 17, 21}};

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

    //O(1)
    public static int queryHard(int x1, int y1, int x2, int y2) {
        int[][] table = integratedTable(grid);
        if (x1 == 0 && y1 == 0)
            return table[x2][y2];
        if (x1 == 0 && y1 > 0)
            return table[x2][y2] - table[x1 - 1][y2];
        if (x1 > 0 && y1 == 0)
            return table[x2][y2] - - table[x2][y1 - 1];
        return table[x2][y2] + table[x1 - 1][y1 - 1] - table[x2][y1 - 1] - table[x1 - 1][y2];
    }

    private static int[][] integratedTable(int[][] grid){
        int row = grid[0].length;
        int column = grid.length;
        int[][] table = new int[column][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (j == 0)
                    table[i][j] = grid[i][j];
                else
                    table[i][j] = table[i][j - 1] + grid[i][j];
            }
        }
        grid = table;
        for (int j = 0; j < column; j++) {
            for (int i = 0; i < row; i++) {
                if (i == 0)
                    table[i][j] = grid[i][j];
                else
                    table[i][j] = table[i - 1][j] + grid[i][j];
            }
        }
        return table;
    }

    public static void update(int x, int y, int v) {
        grid[x][y] = v;
    }

}
