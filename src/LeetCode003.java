import java.util.HashSet;
import java.util.Set;

public class LeetCode003 {
    public  int lengthOfLongestSubstring(String s){
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int rk = 0, ans = 0;
        for(int i = 0; i < n; ++i){
            if(i != 0){
                occ.remove(s.charAt(i-1));
            }
            while(rk < n && !occ.contains(s.charAt(rk ))){
                occ.add(s.charAt(rk ));
                rk++;
            }
            ans = Math.max(ans,rk - i );
        }
        return  ans;
    }

    public static void main(String[] args) {
        LeetCode003 text = new LeetCode003();
        String s = new String("abcabcbb");
        int nums = text.lengthOfLongestSubstring(s);
        System.out.print(nums);
    }
}
