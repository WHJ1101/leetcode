public class LeetCode209 {
    /*
    方法1：暴力法：
        遍历数组，对于没有索引i，往前遍历，累加子数组和，大于目标值s的时候，更新最小子串长度，break
     */
//    public int minSubArrayLen(int s, int[] nums) {
//        int n = nums.length;
//        if(n < 1){
//            return 0;
//        }
//        int ans = n;
//        boolean flag = true;
//        for(int i = 0; i < n; ++i){
//            int temp = 0;
//            for(int j = i; j >= 0; --j){
//                temp += nums[j];
//                if(temp >= s){
//                    flag = false;
//                    ans = Math.min(ans, i - j + 1);
//                    break;
//                }
//            }
//
//        }
//        if(flag){
//            return 0;
//        }
//        return ans;
//    }
    public int minSubArrayLen(int s, int[] nums){
        int n = nums.length;
        if(n < 1){
            return 0;
        }
        int start = 0, end = 0, sum = 0;
        int ans = Integer.MAX_VALUE;
        for(; end < n; ++end){
            sum += nums[end];

            while (sum >= s){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        LeetCode209 lt =new LeetCode209();
        int[] nums = new int[]{2,3,1,2,4,3};
        int s = 20;
        int ans = lt.minSubArrayLen(s,nums);
        System.out.println(ans);
    }
}
