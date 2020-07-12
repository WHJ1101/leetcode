import java.util.Map;

public class LeetCode718 {
    /*
        暴力法：
        我们将以A[i]开头到A[length-1]结尾的子串定义为Ai
        将B[j]开头到B结尾的子串定义为Bj
        暴力法就是对于每一个A[i]
        遍历B数组，找一个Bj中和Ai相同的子串并记录子串长度；
     */
//    public int findLength(int[] A, int[] B) {
//        int nA = A.length;
//        int nB = B.length;
//        int ans = 0;
//        for(int i = 0; i < nA; ++i){
//            for(int j = 0; j < nB; ++j){
//                int k = 0;
//                while(i+k < nA && j+k < nB && A[i+k] == B[j+k]){
//                    k++;
//                    //直接控制i，j++，就改变了外层循环中的索引，会导致遍历不完整；
////                    /*i++;
////                    j++;
////                    */
//
//                }
//                ans = Math.max(ans, k);
//            }
//        }
//        return ans;
//    }
    public int findLength(int[] A, int[] B){
        int nA = A.length;
        int nB = B.length;
        int[][] dp = new int[nA+1][nB+1];//多建一位数组，利用dp[nA][nB]为0来简化便捷判断。

        dp[nA-1][nB-1] = A[nA-1] == B[nB-1] ? 1 : 0;
        int ans = dp[nA-1][nB-1];
        for(int i = nA - 1; i >= 0; --i){
            for (int j = nB - 1; j >= 0; --j){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LeetCode718 lt =new LeetCode718();
        int[] A = new int[]{1,2,3,4,3,2,1};
        int[] B = new int[]{4,3,2,1,4,7};
        int ans = lt.findLength(A,B);
        System.out.println(ans);
    }


}
