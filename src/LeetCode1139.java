public class LeetCode1139 {
    public int largest1BorderedSquare(int[][] grid){
        int n = grid.length;
        if(n == 0){
            return 0;
        }
        int m = grid[0].length;
        int ans = 0;

        int[][][] dp = new int[n + 1][m + 1][2];

        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= m; ++j){
                if(grid[i - 1][j - 1] == 1){
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                    dp[i][j][1] = dp[i - 1][j][1] + 1;

                    int size = Math.min(dp[i][j][0],dp[i][j][1]);
                    while(dp[i][j - size + 1][1] < size ||
                            dp[i - size + 1][j][0] < size){
                        size--;
                    }
                    ans = Math.max(ans, size * size);
                }

            }
        }
        return ans;
    }
}
