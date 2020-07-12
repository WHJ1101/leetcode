import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1691 {
    public int respace(String[] dictionary, String sentence){
        Set<String> dic = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[]dp = new int[n + 1];
        for(int i = 1; i <= n; ++i){
            dp[i] = dp[i - 1] + 1;
            for(int index = 0; index < i; ++index){
                if(dic.contains(sentence.substring(index,i))){
                    dp[i] = Math.min(dp[i], dp[index]);
                }
            }
        }
        return dp[n];
    }

}
