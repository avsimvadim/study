package tricky_tasks;

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(0));
    }
    static int climbStairs(int n){
        if(n == 0 || n == 1){
            return 1;
        }
        return climbStairs(n - 2) + climbStairs(n - 1);
    }
}
