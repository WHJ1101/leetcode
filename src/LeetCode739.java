import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {
    public int[] dailyTemperatures (int[] T){
        int len = T.length;
        int [] ans = new int[len];


        /*
            1.暴力法：
         */
//        for(int i = 0; i < len; ++i){
//            int cnt = 0;
//            for(int j = i + 1; j < len; j++){
//                if(T[j] > T[i]){
//                    cnt = j - i;
//                    break;
//                }
//            }
//            ans[i] = cnt;
//        }
        /*
            2 单调栈：
                相似题目：接雨水、最大矩形面积
                做了这几道题之后，感觉单调栈的作用就是找到后面“第一个”比当前栈顶元素大（小）的元素
         */
        Deque<Integer> stack = new LinkedList<>();//建立单调栈；
        for(int i = 0; i < len; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int index = stack.poll();
                ans[index] = i - index;
            }
            stack.push(i);
        }



        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        LeetCode739 lt = new LeetCode739();
        int [] ans = lt.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ans));
    }
}
