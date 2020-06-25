import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode015 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (n < 3 || nums[0] > 0 || nums[n-1] < 0){
            return ans;
        }
        for(int i = 0; i < n; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = n - 1;
            for(;left < right; ++left){
                //int sum = nums[i] + nums[left] + nums[right];
                if(left > i + 1 && nums[left] == nums[left - 1]){
                    continue;
                }
                while(left < right - 1 && nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                }
            }

        }
        return ans;

    }

    public static void main(String[] args) {
        //int[] nums = new int[]{-2,-1,-1,0,0,0,0,1,2,3};
        int[] nums1 = new int[]{1,2,-2,-1};
        LeetCode015 lt =new LeetCode015();
        //List<List<Integer>> ans = lt.threeSum(nums);
        List<List<Integer>> ans1 = lt.threeSum(nums1);
        //System.out.println(ans.toString());
        System.out.println(ans1.toString());

    }



}
