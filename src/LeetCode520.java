public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        if(word.length() <=1){
            return true;
        }
        int[] arr = toIntArray(word);
        if(arr[0] == 0){
            for(int i = 1; i < arr.length; ++i){
                if (arr[i] == 1){
                    return false;
                }
            }
        }else if(arr[1] == 0){
            for(int i = 2; i < arr.length; ++i){
                if (arr[i] == 1){
                    return false;
                }
            }
        }else {
            for(int i = 2; i < arr.length; ++i){
                if (arr[i] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    private int[] toIntArray(String word){
        int len = word.length();
        int[] ans = new int[len];
        for(int i = 0; i < len; ++i){
            char ch = word.charAt(i);
            if(ch >= 'A' && ch <= 'Z'){
                ans[i] = 1;
            }else{
                ans[i] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode520 text = new LeetCode520();
        String word = "";
        boolean ans = text.detectCapitalUse(word);
        System.out.println(ans);
    }
}
