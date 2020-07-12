public class LeetCode112 {
    /*
        DFS递归
     */
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if(root == null){
//            return false;
//        }
//
//        if(root.left == null && root.right == null){
//            return sum == root.val;
//        }
//
//        return hasPathSum(root.left, sum - root.val)
//                || hasPathSum(root.right, sum - root.val);
//    }

    /*
        回溯法:
        回溯法本身是DFS的变种，相当于是边走边看，
        走到临界条件之后，如果还不满足条件，那么就退回一步
        这个“退回一步”一般是用一个状态量退回到之前的状态；
        至于剪枝优化之类的，目前还没接触到
     */

    int res = 0;
    int flag = 0;

    public boolean hasPathSum(TreeNode root, int sum){
        helper(root, sum);
        return flag == 1;

    }

    private  void helper(TreeNode root, int sum){
        if(root == null) {
            return;
        }
        res += root.val;
        if(res == sum && root.left == null && root.right == null){
            flag = 1;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
        res -= root.val;
    }

}
