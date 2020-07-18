import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1569 {
    public String[] permutation(String s) {
        int len = s.length();
        if(len == 0){
            return new String[0];
        }

        char[]  charArr = s.toCharArray();

        Arrays.sort(charArr);

        StringBuilder path = new StringBuilder();
        boolean[] used = new boolean[len];

        List<String> res = new ArrayList<>();
        dfs(charArr, len, 0, used, path,res);

        return res.toArray(new String[0]);


    }

    private void dfs(char[] charArr,
                     int len,
                     int depth,
                     boolean[] used,
                     StringBuilder path,
                     List<String> res){
        if(depth == len){
            res.add(path.toString());
            return;
        }

        for(int i = 0; i < len; ++i){
            if(!used[i]){
                if(i > 0 && charArr[i] == charArr[i - 1] && !used[i - 1]){
                    continue;
                }

                used[i] = true;
                path.append(charArr[i]);
                dfs(charArr, len, depth + 1, used, path, res);
                path.deleteCharAt(path.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode1569 lt = new LeetCode1569();
        String[] ans = lt.permutation("abc");
        System.out.println(Arrays.toString(ans));
    }
}
