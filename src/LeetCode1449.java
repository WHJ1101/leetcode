import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode1449 {
    public String largestNumber(int[] cost, int target) {
        /*
        * 将cost放入map中，一边相同的花费下只留下数值大的那个
        * 所以要从后往前遍历存入map中
        * */
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = cost.length - 1; i >= 0; --i){
            if(!map.containsKey(cost[i])){
                map.put(cost[i], i + 1);
            }
        }
        /*
        * 状态定义：
        * dp[i]：cost为i时的最大数字
        * */
        String[] dp = new String[target+1];
        dp[0] = "";
        for(int i = 1; i <= target; ++i){
            for(int cst : map.keySet()){
                if(cst <= i && dp[i -cst] != null){
                    String b = dp[i - cst] + map.get(cst);
                    dp[i] = compare(dp[i], b);
                }

            }
        }
        return dp[target] == null ? "0" : dp[target];

    }

    public String compare(String a, String b){
        if(a == null){
            return b;
        }
        if(a.length() > b.length()){
            return a;
        }
        if(a.length() == b.length()){
            if(a.compareTo(b) > 0){
                return a;
            }else{
                return b;
            }
        }
        return b;
    }

}
