import java.util.Arrays;

public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        /*
            思路1：
                直接暴力，双层循环，外循环遍历nums[i]，内循环求除i以外的乘积
         */

//        int n = nums.length;
//        int[] ans = new int[n];
//        for(int i = 0; i < n; ++i){
//            int sum = 1;
//            for(int j = 0; j < n; ++j){
//                if(j != i){
//                    sum *= nums[j];
//                }
//            }
//            ans[i] = sum;
//        }
//        return ans;


        int n = nums.length;
        int[] ans = new int[n];
        int[] lift = new int[n];
        int[] right = new int[n];

        lift[0] = 1;
        right[n-1] = 1;

        for(int i = 1; i < n; ++i){
            lift[i] = nums[i - 1] * lift[i - 1];
        }

        for(int j = n - 2; j >=0; j--){
            right[j] = right[j + 1] * nums[j + 1];
        }


        for(int i = 0; i < n; ++i){
            ans[i] = lift[i] * right[i];
        }


        return ans;
    }

    public static void main(String[] args) {
        LeetCode238 lt = new LeetCode238();
        int[] nums = new int[]{1, 2, 3, 4};
        int[] ans = lt.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }
}
