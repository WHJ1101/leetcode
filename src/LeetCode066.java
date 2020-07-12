import java.util.Arrays;

public class LeetCode066 {
    /*
    数组位数太长，int、long都存不下，作废
     */
//    public int[] plusOne(int[] digits) {
//        //计算digits代表的原数，转存为int
//        long oldNum = 0;
//        int n = digits.length;
//        for(int i = 0; i < n; ++i){
//            oldNum = oldNum * 10 + digits[i];
//        }
//        //用int 计算新数；
//        long newNum = oldNum + 1;
//
//        //计算新整数的位数，并申请相应位数的数组以作为函数的返回值；
//        int cnt = 0;
//        long temp = newNum;
//        while(temp > 0){
//            cnt++;
//            temp /= 10;
//        }
//
//        int[] ans = new int[cnt];
//        //由后向前向返回数组中填充整数的每一位
//        for(int i = cnt - 1; i >= 0; --i){
//            ans[i] = (int)(newNum % 10);
//            newNum /= 10;
//        }
//        return ans;
//    }
    public int[] plusOne(int[] digits) {
        if(everyIs9(digits)){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        int[] ans = new int[digits.length];
//        int last = digits[digits.length - 1] + 1;
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; --i){
            int sum = i == digits.length - 1 ? digits[i] + 1 : digits[i] + carry;
            ans[i] = sum > 9 ? sum % 10 : sum;
            carry = sum / 10;
        }
        return ans;
    }
    private boolean everyIs9(int[] digits){
        for(int i = 0; i < digits.length; ++i){
            if(digits[i] != 9){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode066 lt = new LeetCode066();
        int[] digits = new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6};
        int[] ans = lt.plusOne(digits);
        System.out.println(Arrays.toString(ans));
    }
}
