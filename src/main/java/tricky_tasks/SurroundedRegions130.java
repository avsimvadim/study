package tricky_tasks;

import java.util.Arrays;

public class SurroundedRegions130 {
    public static void main(String[] args) {
        char[][] arr = new char[][]{{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        solve(arr);
        Arrays.stream(arr).forEach(ch -> System.out.println(ch));
    }

    public static void solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    solve(board, i , j);
                }
            }
        }
    }

    private static void solve(char[][] board, int i, int j){
        if(i <= 0 || j <= 0 || i >= board.length - 1 || j >= board[0].length - 1 || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'X';

        solve(board, i - 1, j);
        solve(board, i, j - 1);
        solve(board, i + 1, j);
        solve(board, i, j + 1);
    }
}
