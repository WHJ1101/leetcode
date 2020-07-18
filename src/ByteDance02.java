public class ByteDance02 {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0){
            return "";
        }
        int len0 = strs[0].length();
        int index = len0;
        for(int i = 1; i < n; ++i){
            String temp = strs[i];
            int leni = temp.length();
            len0 = Math.min(leni, len0);
            int j = 0;
            for(j = 0; j < len0; ++j){
                if(strs[0].charAt(j) != temp.charAt(j)){

                    break;
                }
            }
            index = Math.min(index, j);
        }
        return strs[0].substring(0, index);
    }

    public static void main(String[] args) {
        ByteDance02 bd = new ByteDance02();
        String[] strs = new String[]{"aa", "a"};
        String ans = bd.longestCommonPrefix(strs);
        System.out.println(ans);
    }

}
