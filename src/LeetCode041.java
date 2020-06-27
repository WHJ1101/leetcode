import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode041 {
    public int firstMissingPositive(int[] nums) {

        //题目要求：时间复杂度0(n);空间复杂度：O(1)；


        /*
            第一种：
            先排序，然后先找到 nums中元素 1 的索引
                若没有直接返回 1；（第一个缺失的就是1）
            然后从1开始往后遍历，碰到重复的跳过
            碰到两数中间有缺失的（前一个数不等于后一个数-1）
            返回缺失的那个（值=前数+1）
            若遍历完都没有发现有漏的，那就返回nums[n-1] + 1

            就是时间复杂度不符合要求，题目要求O（n）
            排序的时间复杂度已然是O(nlog(n))了。
         */
//        Arrays.sort(nums);
//        int n = nums.length;
//        int start = -1;
//        for(int i = 0; i < n; ++i){
//            if(nums[i] == 1){
//                start = i;
//                break;
//            }
//        }
//        if(start == -1){
//            return 1;
//        }
//        for(int i = start; i < n - 1; ++i){
//            if(nums[i] == nums[i + 1]){//重复元素跳过
//                continue;
//            }
//            if(nums[i] != nums[i + 1] - 1){
//                return nums[i] + 1;
//            }
//
//        }
//        return nums[n - 1] + 1;

        /*
            第二种方法：
            哈希表，直接把元素装入集合
            再从1到N依次判断，是否在集合中；

            这个解法虽然符合了时间复杂度的要求
            但是用到了额外的O(n)的空间。
         */
//        Set<Integer> intSet = new HashSet<>();
//        int n = nums.length;
//        for(int i = 0; i < n; ++i){
//            intSet.add(nums[i]);
//        }
//        for(int i = 1; i <= n; ++i ){
//            if(!intSet.contains(i)){
//                return i;
//            }
//        }
//        return n + 1;
        /*
            第三种方法：
            原地哈希，简单来说就是在原数组上建一个哈希表
            键值对：键：原数组索引；值：索引相对于的元素
            在本题中，一个长度为N的数组
            如果一个正整数都不缺失，那么数组中的值必然是从1~N
            所以我们可以规定1~N之间的数为合法
            不在这个区间的为非法
            然后就是将这些合法的值与“键”也就是原数组索引建立映射
            K：i——V：i+1
            也就是在索引0处，存储整数1
                      1处，存2
                      ...
                      n-1处，存n
            怎么能在O(n)的时间复杂度下完成：
            交换：
            从头遍历，遇到合法值内的数i，将其交换到i-1的位置上
            再从头遍历，遇到不满足nums[i] == i + 1的就返回i+1；

            注意：
                如果有重复的元素，单纯的交换可能会出现死循环，需要额外加判断
         */

        int n = nums.length;
        for(int i = 0; i < n; ++i){
            //int temp = nums[i];
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp - 1] = temp;
            }


        }
        for(int i = 0; i < n; ++i){
            if(nums[i] != i+1){
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        LeetCode041 lt = new LeetCode041();
        int ans = lt.firstMissingPositive(nums);
        System.out.println(ans);
    }
}
