import javax.swing.*;
import java.util.Scanner;

public class LeetCode070 {
    public int climbStairs (int n) {
//        if(n <= 0){
//            return -1;
//        }
//        if(n < 2){
//            return 1;
//        }
//
//        int[] dp = new  int[n+1];
//        dp[0] = 1; dp[1] = 1;
//        for(int i = 2; i <= n; ++i){
//            dp[i] = dp[i-1] + dp[i-2];
//        }
//
//        return dp[n];


        /*
            只与dp[i-1]与dp[i-2]有关，可以用滚动数组来降低空间复杂度；
         */
        if(n < 1){
            return 0;
        }
        int  x= 0, y = 0, ans = 1;
        for(int i = 1; i <= n; ++i){
            x = y;
            y =ans;
            ans = x + y;
        }
        return ans;

    }

    public static void main(String[] args) {
        int n = 0;
        LeetCode070 lt = new LeetCode070();
        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("please enter an int number:");
            n = sc.nextInt();
            System.out.println("your number is :" + n);

            int ans = lt.climbStairs(n);
            System.out.println("your ans is:" + ans);
        }while (n != -1);

    }
}
