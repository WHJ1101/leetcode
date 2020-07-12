import java.util.Arrays;
import java.util.Scanner;

public class LeetCode174 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m - 1][n] = 1;
        dp[m][n - 1] = 1;
        for(int i = m - 1; i >= 0; --i){
            for(int j = n - 1; j >= 0; --j){
                dp[i][j] = Math.max(Math.min(dp[i + 1][j],dp[i][j + 1]) - dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] dungeon = new int[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                dungeon[i][j] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(dungeon));

        LeetCode174 lt = new LeetCode174();
        int ans = lt.calculateMinimumHP(dungeon);
        System.out.println(ans);
    }

}
