package tricky_tasks;

public class RotateArray {
    public static void main(String[] args) {
        //7,1,2,3,4,5,6
        int[] nums = new int[]{7,1,2,3,4,5,6};
        rotate(nums, 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] rotate(int[] nums, int k) {
        for(int i = 0; i < nums.length; i++){
            if(i - k < 0){
                int temp = nums[i];
                nums[i] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
            } else if(i + k < nums.length){
                int temp = nums[i];
                nums[i] = nums[i + k];
                nums[i + k] = temp;
            } else if(i + k > nums.length){
                int temp = nums[i];
                nums[i] = nums[nums.length - i + k];
                nums[nums.length - k - 1] = temp;
            }
        }
        return nums;
    }
}
