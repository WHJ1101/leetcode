import java.util.Deque;
import java.util.LinkedList;

public class LeetCode098 {
    public boolean isValidBST(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        double inOrder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(root.val <= inOrder){
                return false;
            }
            inOrder = root.val;
            root = root.right;
        }
        return true;
    }
}
