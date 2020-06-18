import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1028 {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x){
            val = x;
        }
    }
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<>();
        int pos = 0;
        while (pos < S.length()){
            int level = 0;
            while (S.charAt(pos) == '-'){
                level++;
                pos++;
            }

            int val = 0;

            while(pos < S.length() && Character.isDigit(S.charAt(pos))){
                val = val * 10 + (S.charAt(pos) - '0');
                ++pos;
            }

            TreeNode node = new TreeNode(val);

            if(level == path.size()){
                if(!path.isEmpty()){
                    path.peek().left = node;
                }
            }else{
                while(level != path.size()){
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while(path.size() > 1){
            path.pop();
        }

        return path.peek();


    }
}
