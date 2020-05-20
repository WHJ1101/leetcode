import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1371 {
    /*
    * 题意都理解错了。。。
    * */
//    public int findTheLongestSubstring(String s) {
//        int ans = 0;
//        int cnt = 0;
//        int[] dp = new int[s.length()];
//        dp[0] = isVowel((char) s.charAt(0))? 0 : 1;
//        for(int i = 0; i < s.length()-1; ++i){
//            char let = s.charAt(i);
//            if(isVowel(let) && cnt % 2 == 0){
//                cnt++;
//                dp[i] = dp[i - 1];
//            }
//            if(isVowel(let) && cnt % 2 != 0){
//                cnt++;
//                dp[i] = dp[i - 1] + 1;
//            }
//            if(!isVowel(let)){
//                dp[i] = dp[i - 1] + 1;
//            }
//        }
//        return ans;
//    }
    /*
    * 状态压缩＋哈希表。如1124。
    * 状态压缩后，哈希表的用处是求最长的连续子串，满足子数组的和为k。
    *  此题k为0， 1124题k为1.
    * 遇到奇偶个数校验，想到XOR；
    * 异或：相同为0、不同为1 ；出现偶数次归零，出现奇数次为一；
    * 遇到有限的参数（小于20个）表状态， 想到状态压缩 （bitmask）
    * 遇到求最长的连续子串使得和为k（maximum continuous subarray(substring) with sum equal to k）
    * 想到 前缀和 加哈希表记录第一次出现某一状态的位置。
    * */

    /*
    * 第二版：以HashMap存储状态码；
    * */
//    private static final String VOWELS = "aeiou";
//    public int findTheLongestSubstring(String s) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int size = s.length();
//        int state = 0;
//        int maxSize = 0;
//        map.put(0, -1);//由于i是从0开始的，所以计算长度是把0置为-1；
//        for(int i = 0; i < size; ++i){
//            for(int k = 0; k < VOWELS.length(); ++k){
//                if(s.charAt(i) == VOWELS.charAt(k)){
//                    state ^= (1 << (VOWELS.length() - k - 1));
//                    /*
//                    * 状态码state:
//                    * 对应字符串中以i结尾的字串中，aeiou出现的奇偶次数
//                    * 00000：元音出现次数全为偶数；
//                    * 10000：a出现奇次；
//                    * 01000：e出现奇次；
//                    * 00100：i出现奇次；
//                    * 00010：o出现奇次；
//                    * 00001：u出现奇次；
//                    * 中间叠加的状态码代表多个元音都是奇次；
//                    * 11111：aeiou出现的次数全为奇数次；
//                    * */
//                    break;
//                }
//            }
//            if(map.containsKey(state)){
//                /*
//                * 如果该状态码已经存在，那此时的下标i减去该状态码第一次出现的位置（储存再map中）
//                * 就是当前满足条件的字串长度；
//                * 将其与maxsize比较取大值；
//                * */
//                maxSize = Math.max(maxSize, i - map.get(state));
//            }else{
//                /*
//                * 如果该状态码第一次出现，将其存入map记录其第一次出现的位置；
//                * */
//                map.put(state, i);
//            }
//
//        }
//        return maxSize;
//
//    }

//    public boolean isVowel(char c){
//        if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
//            return true;
//        }else
//            return false;
//    }

    /*
    * 第三版：以一个长度为三十二 的数组存储状态；
    *
    * 思路是一样的，仍然是以状态码记录第一次出现该状态的位置；
    * 再次出现时，两者位置相减即为当前的符合题意的字串长度；
    * 取大值存入ans中以待最后返回；
    * */


    public int findTheLongestSubstring(String s){
        int len = s.length();
        int[] position = new int[32];
        Arrays.fill(position, -1);
        int ans = 0;
        int state = 0;
        position[0] = 0;
        for(int i = 0; i < len; ++i){
            char ch = s.charAt(i);
            if(ch == 'a'){
                state ^= 1;
            }else if(ch == 'e'){
                state ^= 2;
            }else if(ch == 'i'){
                state ^= 4;
            }else if(ch == 'o'){
                state ^= 8;
            }else if(ch == 'u'){
                state ^= 16;
            }

            if(position[state] >= 0){
                ans = Math.max(ans, i+1-position[state]);
            }else {
                position[state] = i + 1;
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        LeetCode1371 text = new LeetCode1371();
        int ans = text.findTheLongestSubstring(s);
        System.out.println(ans);
    }

}
