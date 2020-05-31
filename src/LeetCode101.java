import java.util.ArrayList;
import java.util.List;

public class LeetCode101 {

    /*
        这里本来想用中序遍历二叉树得到一个数组，然后判断该数组是否回文
        但是有两个问题：
            1.树转数组的实现不太熟练
            2.单独一个中序遍历并不能确定一棵二叉树，会有特殊情况造成误判
     */
//    ArrayList<Integer> tree = new ArrayList<>();
//    private ArrayList<Integer> treeList(TreeNode root){
//        if(root == null){
//            return tree;
//        }
//
//    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return check(root.left, root.right);



    }

    /*
        递归永远是一写就废
        递归的三个步骤：
            1.确定baseCase（终止条件）；
            2.返回值的处理；
            3.缩减子问题（确定本级递归要做的内容）。
        步骤1 往往倒是不难找
        然而每次碰到返回值的处理和怎么缩减子问题就头晕
        另外关于要不要写辅助函数也是一头雾水
     */
    private boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return (p.val == q.val) && check(p.left, q.right) && check(p.right, q.left);
    }



}
