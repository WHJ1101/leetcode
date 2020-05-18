public class LeetCode152MaxProductSubarray {
    public int maxProduct(int[] nums) {
        int ans = 0;
        int len =nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        /*
        * 刚开始的想法是直接用dp[i]来表示以nums[i]结尾的子序列的最大乘积；
        * 状态转移方程自然而然：
        * dp[i] = max{nums[i], dp[i-1] * nums[i]};
        * 但是经过检验，发现有BUG：
        * 当数组有多个负数（偶数个）时，比如下面main中的数组，结果应该是除0以外所有元素的积；
        * 但是按照上面的转移方程来算的话，结果是40；
        * 问题就出在上面这个转台转移方程求的是局部最优解，然而局部最优解并不是全局最优解：
        * [2,3,-2], 此时的最优解是 6；
        * 但是对于[2,3,-2,-5]中的子序列[2,3,-2]来说，最优解就是-12，因为后边有个-5，负负得正了。
        * 所以解决办法就是我们需要再用一个数组（也可以直接用dp[2][nums.length]，其中dp[0]是max，dp[1]是min）来记录这个信息；
        * 也就是：
        * max来保存正数中最大的，min来保存负数中最小的；
        * 每次遍历更新max, min数组；
        * 最后再取max中的最大值为ans返回；
        * */
        max[0] = min[0] = nums[0];
        for(int i = 1; i < len; ++i){
            max[i] = Math.max(Math.max(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
            min[i] = Math.min(Math.min(max[i-1] * nums[i], min[i-1] * nums[i]), nums[i]);
        }
        for(int i : max){
            ans = Math.max(i, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, -5, 4, 0};
        LeetCode152MaxProductSubarray text = new LeetCode152MaxProductSubarray();
        int ans = text.maxProduct(nums);
        System.out.println(ans);
    }
}
