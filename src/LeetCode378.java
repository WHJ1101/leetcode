public class LeetCode378 {
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix == null){
            return -1;
        }
        int n = matrix[0].length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        while(left < right){
            int mid = left + (right - left) / 2;
            if(check(matrix, mid, k, n)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean check(int[][] matrix, int mid, int k, int n){
        int i = n - 1;
        int j = 0;
        int cnt = 0;
        while(i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                cnt += i + 1;
                j++;
            }else {
                i--;
            }
        }
        return cnt >= k;
    }
}
