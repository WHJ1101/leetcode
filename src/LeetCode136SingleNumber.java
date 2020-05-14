import java.util.HashSet;
import java.util.Set;

public class LeetCode136SingleNumber {
    public int singleNumber(int[] nums) {
//        int ans = 0;
//        for(int i = 0; i < nums.length; ++i){
//            ans ^= nums[i];
//        }
//
//        return ans;
        Set<Integer> set = new HashSet<>();
        for(Integer i : nums){
            if(set.contains(i)){
                set.remove(i);
            }else{
                set.add(i);
            }
        }
        return set.iterator().next();
    }
}
