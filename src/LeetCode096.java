public class LeetCode096 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        LeetCode096 lt = new LeetCode096();
//        int ans = lt.numTrees(5);
//        System.out.println(ans);
        System.out.println(new LeetCode096().numTrees(4));
    }
}
