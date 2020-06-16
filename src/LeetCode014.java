public class LeetCode014 {
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        int n = strs.length;
        if(n == 0){
            return ans;
        }

        String s = strs[0];
        int len0 = s.length();
        int index = len0;

        for(int i = 1; i < n; ++i){
            String temp = strs[i];
            int m = temp.length();
            len0 = Math.min(m,len0);
            int j = 0;
            for(j = 0; j < len0; ++j){
                if(temp.charAt(j) != s.charAt(j)){
                    break;
                }
            }
            index = Math.min(index,j);
        }
        ans = s.substring(0,index);

        return ans;
    }

    public static void main(String[] args) {
        LeetCode014 lt = new LeetCode014();
        String[] strs = new String[]{"c","ac","ccc"};
        String ans = lt.longestCommonPrefix(strs);
        System.out.println(ans);
    }
}
