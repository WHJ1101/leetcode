public class LeetCode053 {
    public static int maxSubArray(int[] nums){
        int max = nums[0];

        for(int i = 0; i < nums.length; ++i){
            int sum =0;
            for(int j = i; j < nums.length; ++j){
                sum += nums[j];
                max = Math.max(max,sum);
            }
        }
        return max;
    }

    public static int TXmaxSubArray(int[] nums){
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; ++i){
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = LeetCode053.maxSubArray(nums);
        int ans1 = LeetCode053.TXmaxSubArray(nums);
        System.out.println(ans);
        System.out.println(ans1);
    }

}
