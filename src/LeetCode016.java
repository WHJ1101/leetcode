public class LeetCode016 {
    public int threeSumClosest(int[] nums, int target) {
        //暴力解法，三重循环遍历出所有的三个整数的组合，比较它们的和与target的差距，取最小的那个
        int ans = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                for(int k = j + 1; k < n; ++k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if((Math.abs(target - sum)) < Math.abs(target - ans)){
                        ans = sum;
                    }
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LeetCode016 lt = new LeetCode016();
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        int ans = lt.threeSumClosest(nums, target);
        System.out.println(ans);
    }

}
