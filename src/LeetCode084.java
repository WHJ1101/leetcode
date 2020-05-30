import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class LeetCode084 {
    /*
    * 一开始想估计是DP，但是想了半天，连状态怎么定义都想不出来
    * 只能先用暴力求解
    * 没想到竟然AC了。。
    * 应该是测试组仁慈了
    * */
//    public int largestRectangleArea(int[] heights) {
//        int ans = 0;
//        int n = heights.length;
//        for(int i = 0; i < n; ++i){
//            int h = heights[i];
//            for(int j = i; j < n; ++j){
//                h = Math.min(h, heights[j]);
//                int s = h * (j - i + 1);
//                ans = Math.max(s, ans);
//            }
//        }
//
//        return ans;
//    }

    /*
    *
    * 这个解法的思路是基于另一种暴力解法而来的：
    * 第一种暴力是枚举了每一个矩形的宽，然后再求出该矩形的高（改子数组内最矮的那个即为整个矩形的高）
    *
    *
    * 另一种暴力是枚举每一个矩形的高，也就是将数组内第i个元素作为矩形的高
    * 每次以该元素为中心，往两边再次遍历，直到再左右两边分别找到第一个矮于该元素的元素
    * 找到的这两个元素就是以元素i为高的矩形的左右端点，也就是边长；
    * 对整个数组元素进行遍历，找到面积最大的；
    *
    * 这个方法的缺点就是每次往两边遍历的时候时间复杂度都是O(n)
    * 考虑如何将其讲到O(1)
    * 想到是不是可以用一种什么数据结构把左边的值给保存起来，这样每次找端点的时候直接取出来就可以了
    *
    * 注意到，左右端点的特点是：距离第i个元素最近的小于它的那个元素
    * 那就可以用一个单调栈来存储高度
    * 遍历数组，碰到比栈顶元素大的就直接入栈
    * 否则就说明碰到了栈顶元素的右端点；
    * 而此时栈顶元素的下一位就是它左边离它最近的比它小的元素，也就是左端点
    * 这么一来就可以计算这个矩形的面积了
    * */
    public int largestRectangleArea(int[] heights){
        int n = heights.length;

        if(n == 0){
            return 0;
        }

        if(n == 1){
            return heights[0];
        }

        int[] temp = new int[n + 2];
        System.arraycopy(heights, 0, temp, 1, n);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for(int i = 0; i < n + 2; ++i){
            while(!stack.isEmpty() && temp[i] < temp[stack.peek()]){
                int h = temp[stack.pop()];
                int w = i - stack.peek() - 1;
                area = Math.max(area, h * w);
            }
            stack.push(i);
        }
        return area;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{2, 1, 5, 6, 2, 3};
        LeetCode084 lt = new LeetCode084();
        int ans = lt.largestRectangleArea(heights);
        System.out.println(ans);
    }
}
