package tricky_tasks;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        System.out.println(jump(nums, 0, 0));
    }

    static int jump(int[] nums, int curIndex, int jumpsCounter) {

        if(nums.length == 1){
            return 0;
        }
        for(int i = 1; i < nums[curIndex]; i ++){
            if(curIndex + i == nums.length - 1){
                return jumpsCounter + 1;
            }
        }


        int min = Integer.MAX_VALUE;
        for(int i = 1; i < nums[curIndex]; i++){
            min = Math.min(min, jump(nums, curIndex + i, jumpsCounter + 1));
        }

        return min;
    }
}
