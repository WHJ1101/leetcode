public class LeetCode1583 {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        if(n < 2){
            return 0;
        }
        int[] copy = new int[n];
        for(int i = 0; i < n; ++i){
            copy[i] = nums[i];
        }
        int[] temp = new int[n];
        return helper(nums, 0, n - 1, temp);

    }
    public int helper(int[] nums, int left, int right, int[] temp){
        if(left == right){
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftPart = helper(nums, left, mid, temp);
        int rightPart = helper(nums, mid + 1, right, temp);

        if(nums[mid] <= nums[mid + 1]){
            return leftPart + rightPart;
        }

        int crossPart = mergeAndCount(nums, left, mid, right, temp);

        return leftPart + rightPart +crossPart;
    }

    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp){
        for(int i = left; i <= right; ++i){
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int count = 0;

        for(int k = left; k <= right; k++){
            if(i == mid +1){
                nums[k] = temp[j];
                j++;
            }else if(j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else{
                nums[k] = temp[j];
                j++;

                count += (mid - i + 1);
            }
        }
        return count;
    }

}
