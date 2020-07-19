
//二叉树的直径
public class LeetCode543 {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;

    }

    private int dfs(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);

        ans = Math.max(ans, l+r);

        return Math.max(l, r) + 1;
    }
}
