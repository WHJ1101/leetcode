public class LeetCode005 {

    /*
    * 遇到“最长字串”这种的，可以考虑用DP；
    * 且可以重点考虑dp[i]：代表以i结尾的子串满足题意的最大长度
    * 但是这道题不光要求长度，还要输出该子串；
    * */
//    public String longestPalindrome(String s) {
//        int[] pos = Helper(s, 0 , s.length()-1);
//        int l = pos[0];
//        int r = pos[1];
//
//        String ans = s.substring(l,r);
//
//        System.out.println(ans);
//
//        return ans;
//    }
//    private int[] Helper (String s, int l, int r){
//        int[] pos = new int[2];
//        if(l == r){
//            pos[0] = l;
//            pos[1] = r + 1;
//
//        }else if(s.charAt(l) == s.charAt(r)){
//            /*
//            * 当首位字母相同的时候，下一步应该分情况：
//            * 若[l+1,r-1]之间的是回文子串，则，pos[0]=l;pos[1]=r+1;
//            * 若不是，则递归返回Helper(s,l+1,r-1)；
//            *
//            * 遇到的问题就是怎么区分这两种情况；
//            * 一种思路是在pos数组里再加以为即pos = new int[3];
//            * 其中pos[2]储存一个标记，初始为1，在递归过程中，如果出现不是回文子串的就返回0；
//            * 但是具体实施遇到了困难；说是该条件始终为真；
//            * 另一种思路是在Helper方法中加一个int flag参数，
//            * 但是涉及到递归函数中的参数传递，理解的不透彻，实现不出来；
//            * */
//            pos = Helper(s,l+1, r-1);
//        }else{
//            int[] left = Helper(s, l + 1, r);
//            int[] right = Helper(s, l, r -1);
//            int t1 = left[1] - left[0];
//            int t2 = right[1] - right[0];
//            if(t1 > t2){
//                pos = left;
//            }else{
//                pos = right;
//            }
//        }
//        return pos;
//    }

    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] P = new boolean[length][length];
        int maxLen = 0;
        String maxPal = "";
        for (int len = 1; len <= length; len++) //遍历所有的长度
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) //下标已经越界，结束本次循环
                    break;
                P[start][end] = (len == 1 || len == 2 || P[start + 1][end - 1]) && s.charAt(start) == s.charAt(end); //长度为 1 和 2 的单独判断下
                if (P[start][end] && len > maxLen) {
                    maxPal = s.substring(start, end + 1);
                }
            }
        return maxPal;

    }


    public static void main(String[] args) {
        String s = "abcba";
        LeetCode005 text = new LeetCode005();
        String ans = text.longestPalindrome(s);
        System.out.println(ans);

    }
}
