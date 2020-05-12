public class LeetCode069 {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }

        int left = 0;
        int right = x;
        int mid;
        int ans = -1;

        while(left <= right){
            mid = left + (right - left) / 2;
            if(x/mid >= mid){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        int x = 9;
        LeetCode069 text = new LeetCode069();
        int ans = text.mySqrt(x);
        System.out.println(ans);
    }
}
