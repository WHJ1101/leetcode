public class LeetCode063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        /*
            多加一行一列，起到哨兵的作用，赋初值要容易一点
            dp中第0行、第0列全为0；
            最后结果保存在dp[m][n]中。
         */
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 1; i <= m; ++i){//注意边界
            for(int j = 1; j <= n; ++j){
                if(i == 1 && j == 1){
                    /*
                        dp数组和obstacleGrid数组索引值是相差1的，注意细节。
                     */
                    dp[i][j] = obstacleGrid[i - 1][j - 1] == 1 ? 0 : 1;
                }else{
                    dp[i][j] = obstacleGrid[i - 1][j - 1] == 1 ? 0
                            : dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LeetCode063 lt = new LeetCode063();
        int[][] nums = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        int ans = lt.uniquePathsWithObstacles(nums);
        System.out.println(ans);
    }
}
