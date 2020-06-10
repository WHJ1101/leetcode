import java.util.Arrays;

/*
    这道题完美符合递归转化为动态规划的类型；
    递归时自顶而下；DP是自下而上；
    DP的优点就是优化了递归树中的重复子树；提高了时间复杂度；

    这道题正常做法：
    如果num是一个数组，那就好办了：
    nums[]={1,2,2,5,8}
    先考虑最末尾的8：只有一种翻译方法；
    再考虑最后两位58：因为58超过了25，也即超过了字母的表示范围，不能合在一起表示，那只能分开翻译：5+8，也是1种；
    再考虑最后三位258：这时候就可以先把258分为2+58和25+8两种翻译方法；其中58和8的翻译方法由上两步都可以直接拿过来用：1+1=2种；
    依此类推：
    2258可以分为2+258和22+58；258有两种翻译方法，58有一种；那加起来就是2258的翻译方法：3种；
    12258：1+2258和12+258 = 3+2 = 5种；
    那经过上面分析：
    我们可以直接定义状态：dp[i]代表第i位及其后面的数组总共有多少种翻译方法
    （这是nums数组转化为数组之后正序的情况下的定义）
    当dp[i]*10+dp[i+1]在10到25之间时：
        dp[i] = dp[i+1]+dp[i+2]；
    否则：
        dp[i] = dp[i+1]
    这样从后往前遍历过来，最后返回dp[0]即为所求。


    但是本题还有一个细节：
        传递过来的是一个int整数；
        这就需要先把整数转换为数组；
        我是用的循环/=；
        这就导致了数组时倒序的，比如题目中的例子：12258
        转换成数组之后就成了：{8,5,2,2,1}
        不过这个其实也不影响，把状态转移方程也倒一下就可以了，具体实现见下面代码
*/

public class LeetCode_InterView046 {
    public int translateNum(int num) {
        if(num == 0){
            return 1;
        }
        String s =String.valueOf(num);
        System.out.println(s);
        int ans = 0;
        int cnt = 0;//先算出num的位数；
        int temp = num;
        while(temp >0){
            temp /= 10;
            cnt++;
        }
        int [] nums = new int[cnt];
        int [] dp = new int[cnt];


        for(int i = 0; i < cnt; ++i){
            //再倒序装入数组
            nums[i] = num % 10;
            num /= 10;
        }
        /*
            上面这段代码感觉特别的繁琐
         */

        //System.out.println(Arrays.toString(nums));

        dp[0] = 1;//设置初值；

        for(int i = 1; i < cnt; ++i){

            int mul = nums[i]*10 + nums[i-1];

            if(i == 1){
                /*
                    先判断一下，防止数组越界
                 */
                if(mul >= 10 && mul <= 25){
                    dp[1] = 2;
                }else{
                    dp[1] = 1;
                }
            }else{
                /*
                    状态转移方程：和上面的下标转化一下就可以了

                 */
                if(mul >= 10 && mul <= 25){
                    dp[i] = dp[i-1] + dp[i-2];
                }else{
                    dp[i] = dp[i-1];
                }
            }
        }
        ans = dp[cnt-1];//同样，返回的值也变成了数组最后一位。
        return ans;
    }

    public static void main(String[] args) {
        int num = 12258;
        LeetCode_InterView046 lt = new LeetCode_InterView046();
        int ans = lt.translateNum(num);
        System.out.println(ans);

    }

}
