import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LeetCode020 {
    public boolean isValid(String s) {
        int n = s.length();
        if(n % 2 == 1){
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < n; ++i){
            char temp = s.charAt(i);
            if(temp == '(' || temp == '[' || temp == '{'){
                stack.push(temp);
            }else{
                if(!stack.isEmpty()){
                    if(temp == ')'){
                        if( stack.peek() == '('){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }

                    if(temp == ']')
                        if(stack.peek() == '['){
                            stack.pop();
                        }else{
                            return false;
                        }
                    if(temp == '}')
                        if(stack.peek() == '{'){
                            stack.pop();
                        }else{
                            return false;
                        }

                }else{
                    stack.push(temp);
                }
            }
        }
        if( !stack.isEmpty()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode020 lt = new LeetCode020();
        String s = "({{[]}}){}[])";
        boolean ans = lt.isValid(s);
        System.out.println(ans);
    }
}
