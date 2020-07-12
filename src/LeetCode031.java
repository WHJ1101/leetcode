public class LeetCode031 {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n <= 1){
            return;
        }
        int i = n - 2, j = n - 1, k = n -1;
        for(; i >= 0; i--,j--){
            if(nums[i] < nums[j]){
                break;
            }
        }
        if(i >= 0){
            while(nums[i] >= nums[k]){
                k--;
            }
            swap(nums, i, k);
        }
        int l = j, r = n - 1;
        while(l <= r){
            swap(nums, l, r);
            l++;
            r--;
        }

    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
