import java.util.Arrays;

public class LeetCode034 {
    public int[] searchRange(int[] nums, int target) {
        int position = binSearch(nums, 0, nums.length - 1, target);
        if(position == -1){
            return new int[]{-1, -1};
        }
        int left = position, right = position;
        while(position > 0 && nums[position - 1] == nums[position]){
            left = position -1;
            position--;
        }
        while(position < nums.length - 1 && nums[position + 1] == nums[position]){
            right = position + 1;
            position ++;
        }
        return new int[]{left, right};

    }

    private int binSearch(int[] nums, int left, int right, int target){
        if( left > right){
            return -1;
        }
        int mid = left + (right - left) / 2;
        if(nums[mid] > target){
            return binSearch(nums, left, mid - 1, target);
        }else if(nums[mid] < target){
                return binSearch(nums, mid + 1, right, target);
        }else{
            return mid;
        }

    }

    public static void main(String[] args) {
        LeetCode034 lt = new LeetCode034();
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 10;
        int[] ans = lt.searchRange(nums,target);
        System.out.println(Arrays.toString(ans));
    }
}
