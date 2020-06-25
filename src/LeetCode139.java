import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        int maxSize = 0;//记录字典中单词的最大长度
        for(int i = 0; i < wordDict.size();i++){
            maxSize = Math.max(maxSize, wordDict.get(i).length());
        }
        for(int i = 1; i <= s.length(); i++){
//            for(int j = 0; j < i; ++j){
//                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
//                    dp[i] = true;
//                    break;
//                }
//            }
            for(int j = i - 1; j >= 0; j--){
                /*
                从后往前遍历子串，在遇到子串中有重复单词的时候可以提高效率；？
                如果i-j的长度超过了字典中单词的最大长度，那么可以直接跳出这个子串；
                 */
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
                if(i - j > maxSize + 1){
                    break;
                }
            }
        }
        return dp[s.length()];

    }
}
