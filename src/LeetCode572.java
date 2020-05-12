





public class LeetCode572 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    /*对s中的节点进行DFS遍历判断该节点的子树是否和t相同
    * */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null){
            return true;
        }
        if (s == null && t != null){
            return false;
        }
        /*
        * 子树是否和t相同：
        * 要么本身和t相同
        * 要么左子树和t相同
        * 要么右子树和t相同
        * */
        return isSameTree(s, t)
                || isSubtree(s.left, t)
                || isSubtree(s.right, t);
    }
    //判断s中的节点的子树是否和t相同
    private boolean isSameTree(TreeNode s, TreeNode t){
        if (s == null && t == null){
            return true;//递归终止条件，空树返回true
        }
        /*两棵树相同：根节点同时为空或者同时不为空（为空终止条件已经判断）
        *           且根节点值相同
        *           且左子树与右子树同时都相同
        * */
        return s != null && t != null
                && s.val == t.val
                && isSameTree(s.left, t.left)
                && isSameTree(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1, null, null);
        TreeNode right = new TreeNode(2,null,null);
        left = new TreeNode(4,left,right);
        right = new TreeNode(5,null,null);
        TreeNode root1 = new TreeNode(3,left,right);
        TreeNode root2 = left;
        LeetCode572 text = new LeetCode572();
        System.out.println(text.isSubtree(root1,root2));


    }

}
