import java.util.HashMap;

public class LeetCode560SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
//        int ans = 0;
//        for(int i = 0; i < nums.length; ++i){
//            int sum = 0;
//            for(int j = i; j < nums.length; ++j){
//                sum += nums[j];
//                if(sum == k){
//                    ans++;
//                    break;
//                }else if(sum > k){
//                    break;
//                }
//            }
//        }
//
//        return ans;

        /*上面这段代码有BUG：
        * 不能处理 nums里面有负数的情况；
        * */

        int count = 0, pre = 0;
        HashMap < Integer, Integer > mp = new HashMap< >();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k))
                count += mp.get(pre - k);
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;


    }

    public static void main(String[] args) {
        LeetCode560SubarraySumEqualsK text = new LeetCode560SubarraySumEqualsK();
        int[] nums = new int[]{1,2,3,4,3,4,5};
        int ans = text.subarraySum(nums, 7);
        System.out.println(ans);
    }
}
