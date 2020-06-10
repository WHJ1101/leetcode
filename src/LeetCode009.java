import java.util.Arrays;

public class LeetCode009 {
//    public boolean isPalindrome(int x) {
//        boolean ans = true;
//
//        String s =  String.valueOf(x);
//        //System.out.println(s);
//
//        int n = s.length();
//        //System.out.println(n);
//
//        System.out.println(s.substring(0,n));
//
//        for(int i = 0; i < n/2; ++i){
//            if(!s.substring(i,i+1).equals(s.substring(n-i-1,n-i))){
//                ans = false;
//                break;
//            }
//        }
//
//        return ans;
//
//    }
    public boolean isPalindrome(int x) {
        boolean ans = true;
        if(x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }
        int temp = x;
        int cnt = 0;
        while(x > 0){
            x /= 10;
            cnt++;
        }
        int[] nums = new int[cnt];
        for(int i = 0; i < cnt; ++i){
            nums[i] = temp % 10;
            temp /= 10;
        }

        //System.out.println(Arrays.toString(nums));


        for(int i = 0; i < cnt/2; ++i){
            if(nums[i] != nums[cnt - 1 - i]){
                ans = false;
                break;
            }
        }

        return ans;

    }


    public static void main(String[] args) {
        int x = 1234;
        LeetCode009 lt = new LeetCode009();
        System.out.println(lt.isPalindrome(x));
    }

}
