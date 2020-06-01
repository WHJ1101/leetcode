import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MIN_VALUE;

public class LeetCode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;
        int max = MIN_VALUE;
        List<Boolean> ans = new ArrayList<Boolean>(n);
        for(int i : candies){
            max = Math.max(max, i);
        }
        int flag = max - extraCandies;

        for(int i = 0; i < n; ++i){
            if(candies[i] < flag){
                ans.add(false);
            }else{
                ans.add(true);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{12,1,12};
        int extraCandies = 11;
        LeetCode1431 lt = new LeetCode1431();
        List<Boolean> ans = lt.kidsWithCandies(candies, extraCandies);
        System.out.println(ans);
    }

}
