import java.util.Arrays;

public class LeetCode016 {
//    public int threeSumClosest(int[] nums, int target) {
//        //暴力解法，三重循环遍历出所有的三个整数的组合，比较它们的和与target的差距，取最小的那个
//        int ans = nums[0] + nums[1] + nums[2];
//        int n = nums.length;
//        for(int i = 0; i < n; ++i){
//            for(int j = i + 1; j < n; ++j){
//                for(int k = j + 1; k < n; ++k){
//                    int sum = nums[i] + nums[j] + nums[k];
//                    if((Math.abs(target - sum)) < Math.abs(target - ans)){
//                        ans = sum;
//                    }
//                }
//            }
//        }
//        return ans;
//    }

    /*
    改了半天还是一堆BUG，艹
     */
//    public int threeSumClosest(int[] nums, int target) {
//        int ans = nums[0] + nums[1] + nums[2];
//        Arrays.sort(nums);
//        int n =nums.length;
//        for(int i = 0; i < n; ++i){
//            if(i > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }
//            int left = i + 1, right = n - 1;
//            for(; left < right; ++left){
//                if(left > i + 1 && nums[left] == nums[left - 1]){
//                    continue;
//                }
//
////                if(nums[i] + nums[left] + nums[right] == target){
////                    return sum;
////                }
//
//                while(nums[i] + nums[left] + nums[right] > target && left < right - 1){
//                    right--;
//                }
//                int sum = nums[i] + nums[left] + nums[right];
//                ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
//            }
//        }
//        return ans;
//
//    }

    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < n; ++i){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1, right = n -1;
            while (left < right){

                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }
                ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;

//                if(sum > target){
//                    int r = right - 1;
//                    while ((left < r && nums[r] == nums[right])){
//                        --r;
//                    }
//                    right = r;
//                }else{
//                    int l = left + 1;
//                    while ((l < right && nums[l] == nums[left])){
//                        ++l;
//                    }
//                    left = l;
//                }
                if(sum > target){
                    right--;
                }else{
                    left++;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode016 lt =new LeetCode016();
        int[] nums = new int[]{-3,-2,-5,3,-4};
        int target = -1;
        int ans = lt.threeSumClosest(nums,target);
        System.out.println(ans);
    }
}
