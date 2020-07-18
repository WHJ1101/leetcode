public class LeetCode198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int max = nums[0];
        int[] dp = new int[n + 2];
        for(int i = 2; i < n + 2; ++i){
            dp[i] = Math.max(dp[i - 2] + nums[i - 2], dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        return max;

    }

    public static void main(String[] args) {
        LeetCode198 lt = new LeetCode198();
        int[] nums = new int[]{1,2,3,1};
        int ans = lt.rob(nums);
        System.out.println(ans);
    }
}
