public class LeetCode680 {
//    public boolean validPalindrome(String s) {
//        /*
//        * 初始思路是利用双指针来解：
//        * 左右指针分别指向头尾，如果两指针所指的值相同，则同时往中间移动一位；
//        * 但是当不同的时候，思路出现了BUG：只想到了单独移动右指针后看是否相同
//        * 忽略了移动左指针的情况；
//        * 所以，只用一个flag变量来记录信息已经不够了，
//        * 需要用辅助函数来判断移动左指针或者右指针后是否相同
//        * */
//        int len = s.length();
//        int left = 0;
//        int right =len -1;
//        boolean flag =false;
//        while(left <= right){
//            if(s.charAt(left) != s.charAt(right)){
//                if(!flag){
//                    right--;
//                    flag = true;
//                }else{
//                    return false;
//                }
//            }else{
//                left++;
//                right--;
//            }
//        }
//        return true;
//    }
    /*
    * 第二版：利用辅助函数
    * */
//    public boolean validPalindrome(String s){
//        int left = 0;
//        int right = s.length() - 1;
//        while (left <= right){
//            if(s.charAt(left) != s.charAt(right)){
//                return isSam(s,left+1, right) || isSam(s, left, right-1);
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//
//    private boolean isSam(String s, int l, int r){
//        while(l < r){
//            if(s.charAt(l) != s.charAt(r)){
//                return false;
//            }
//            l++;r--;
//        }
//        return true;
//    }
    /*
    *第三版：递归
    * */
    int cnt = 0;
    public boolean validPalindrome(String s){
        int l = 0;
        int r = s.length() - 1;
        while(l <= r){
            if(s.charAt(l) == s.charAt(r)){
                l++;r--;
            }else{
                if(cnt == 0){
                    cnt++;
                    return validPalindrome(s.substring(l+1,r+1)) || validPalindrome(s.substring(l,r));
                }
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new String("abc");
        LeetCode680 text = new LeetCode680();
        boolean ans = text.validPalindrome(s);
        System.out.println(ans);

    }
}
