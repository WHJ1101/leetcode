public class LeetCode221 {
    public int maximalSquare(char[][] matrix) {

        int max = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return max;
        }
        int row = matrix.length, col = matrix[0].length;
        /*定义状态：dp[i][j]代表i，j处的最大正方形面积；
        * */
        int[][] dp = new int[row][col];
        /*初始化初值，dp第0行、第0列按个赋值；
        * */
        for(int i = 0; i < row; ++i){
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(max, dp[i][0]);
        }
        for(int i = 0; i < col; ++i){
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(max, dp[0][i]);
        }
        for(int i = 1; i < row; ++i){
            for(int j = 1; j < col; ++j){
                if(matrix[i][j] == '0'){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]);
                    dp[i][j] = Math.min(dp[i][j],dp[i][j-1]);
                    dp[i][j] += 1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        LeetCode221 text = new LeetCode221();
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        int max = text.maximalSquare(matrix);
        System.out.println(max);
    }
}
