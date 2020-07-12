public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x){
        val = x;
    }
    public TreeNode(int x , TreeNode left, TreeNode right){
        val = x;
        this.left = left;
        this.right = right;
    }
}
