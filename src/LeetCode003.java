import java.util.HashSet;
import java.util.Set;

public class LeetCode003 {
    public  int lengthOfLongestSubstring(String s){
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int right = -1;
        for(int i = 0; i < s.length(); ++i){
            if(i != 0){
                set.remove(s.charAt(i));
            }

            while(right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                right++;
            }

            ans = Math.max(ans, right - i + 1);

        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode003 text = new LeetCode003();
        String s = new String("abcabcbb");
        int nums = text.lengthOfLongestSubstring(s);
        System.out.print(nums);
    }
}
