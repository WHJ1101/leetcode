import java.util.Deque;
import java.util.LinkedList;

public class LeetCode071 {
    public String simplifyPath(String path){
        Deque<String> stack = new LinkedList<>();
        for(String s : path.split("/")){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.isEmpty() && !s.equals(".")){
                stack.push(s);
            }
        }

        String res = "";
        for(String s : stack){
            res = "/" + s + res;
        }
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        LeetCode071 lt = new LeetCode071();
        String path = "/a/./b/../../c/";
        String ans = lt.simplifyPath(path);
        System.out.println(ans);
    }
}
