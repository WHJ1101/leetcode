import java.util.HashSet;
import java.util.Set;

public class ByteDance01 {
    public int lengthOfLongestSubstring(String s){
        int ans = 0;
        Set<Character> set = new HashSet<>();
        int right = -1;
        for(int i = 0; i < s.length(); ++i){
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                ++right;
            }
            ans = Math.max(ans, right - i + 1);
        }
        return ans;
    }
}
