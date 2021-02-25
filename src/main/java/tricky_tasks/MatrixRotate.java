package tricky_tasks;
//counterclockwise rotate without using additional space
//1 2 3 4
//5 6 7 8
//9 10 11 12
//13 14 15 16
//->
//4 8 12 16
//3 7 11 15
//2 6 10 14
//1 5 9 13
public class MatrixRotate {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] arr){
        //transponse
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = tmp;
            }
        }
        //flip
        for (int i = 0; i < arr.length / 2; i++) {
            for (int j = 0; j < arr.length; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[arr.length - i - 1][j];
                arr[arr.length - i - 1][j] = tmp;
            }
        }

    }
}
