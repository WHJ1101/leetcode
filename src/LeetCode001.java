import java.util.Arrays;
import java.util.HashMap;

public class LeetCode001 {
    public int[] twoSum(int[] nums, int target) {
        /*
        int[] ans = new int[]{-1,-1};
        int n = nums.length;
        int i, j;
//        boolean flag = false;
        for(i = 0; i < n; ++i){
            for(j = i + 1; j < n; ++j){
                if(nums[i] + nums[j] == target){
//                    flag = true;
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
//            if(flag){
//                break;
//            }
        }
        return ans;
        */
        HashMap<Integer, Integer> map = new HashMap<>();


        for(int i = 0; i < nums.length; ++i){

            int temp = target - nums[i];
            if(map.containsKey(temp) ){
                int[] ans = new int[]{map.get(temp) ,i };
                return ans;
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("No Solution");

    }

    public static void main(String[] args) {
        LeetCode001 lt = new LeetCode001();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ans = lt.twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}
