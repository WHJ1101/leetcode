public class LeetCode062 {
    /*
    用滚动数组来代替二维dp数组。
     */
    public int uniquePaths(int m, int n) {
        int[]dp = new int[m];
        dp[0] = 1;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        LeetCode062 lt = new LeetCode062();
        int m = 3, n =2;
        int ans = lt.uniquePaths(m, n);
        System.out.println(ans);
    }
}
