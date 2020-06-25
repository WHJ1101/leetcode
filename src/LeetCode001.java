import java.util.Arrays;
import java.util.HashMap;

public class LeetCode001 {
    public int[] twoSum(int[] nums, int target)  {

        /*
        暴力法就是两个for循环，找到所有的组合，判断是否和target相同；
        其实也可以这么看，在第一层循环中我们遍历每个i，
        然后继续遍历剩下的元素，期望能找到一个元素，它的值==target - nums[i]；
        这个过程又花费了O（n）的时间复杂度；
        如果能有O(1)的操作来找到第二个元素，那么整个解法的时间复杂度也就下来了
        O(1)的select复杂度：可以尝试用HashMap:
        这是两遍哈希：
        第一遍把数组中的元素put到哈希表中，
        第二遍遍历时，判断哈希表中是否包含目标值；
         */
//        HashMap<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < nums.length; ++i){
//            map.put(nums[i],i);
//        }
//
//        for(int i = 0; i < nums.length; ++i){
//            int temp = target - nums[i];
//            if(map.containsKey(temp) && map.get(temp) != i){
//                return new int[]{i, map.get(temp)};
//            }
//        }
//        throw new IllegalAccessException("NO SOLUTION");
        /*
        一遍哈希：
        在往map中添加元素nums[i]之前，我们先判断一下索引i之前的数组元素中是否包含有我们所需的：
        target-nums[i]的值；
        这样就可以一次遍历得到答案。
         */
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("NO SOLUTION");

    }

    public static void main(String[] args)  {
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        LeetCode001 lt = new LeetCode001();
        int[] ans = lt.twoSum(nums,target);
        System.out.println(Arrays.toString(ans));
    }
}
