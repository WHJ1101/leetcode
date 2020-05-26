public class LeetCode287 {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;
        int ans = -1;
        while(left <= right){
            int cnt = 0;
            int mid = (left + right) >> 1;
            for(int i = 0; i < len; i++){
                if (nums[i] <= mid){
                    cnt++;
                }
            }
            if(cnt <= mid){
                left = mid + 1;
            }else{
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        LeetCode287 text = new LeetCode287();
        int[] nums = new int[]{1, 3, 4, 2, 2};
        int ans = text.findDuplicate(nums);
        System.out.println(ans);
    }
}
