public class LeetCode1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0;
        int mx = A[0] + 0;
        for(int i = 1; i < A.length; ++i){

            int temp = mx + A[i] -i;
            ans = Math.max(ans,temp);
            mx = Math.max(mx, A[i] + i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = new int[]{8,1,5,2,6};
        LeetCode1014 lt = new LeetCode1014();
        int ans = lt.maxScoreSightseeingPair(A);
        System.out.println(ans);
    }
}
