import javax.swing.tree.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode107 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ans = new ArrayList<>();
//        Queue<TreeNode> queue = new ArrayDeque<>();
//
//        if(root != null){
//            queue.add(root);
//        }
//        while(!queue.isEmpty()){
//            int n = queue.size();
//
//            List<Integer> level = new ArrayList<>();
//            for(int i = 0; i < n; ++i){
//                TreeNode node = queue.poll();
//                level.add(node.val);
//                if(node.left != null){
//                    queue.add(node.left);
//                }
//                if(node.right != null){
//                    queue.add(node.right);
//                }
//            }
//            ans.add(level);
//        }
//
//
//        List<List<Integer>> temp = reserve(ans);
//        return temp;
//    }
//    private List<List<Integer>> reserve (List<List<Integer>> old){
//        int n = old.size();
//        List<List<Integer>> newAns = new ArrayList<>();
//        for(int i = 0; i < n; ++i){
//            newAns.add(old.remove(n- 1 - i));
//        }
//        return newAns;
//    }
//
//    public static void main(String[] args) {
//        LeetCode107 lt = new LeetCode107();
//        List<List<Integer>> text = new ArrayList<>();
//        for(int j = 0; j < 3; ++j){
//            List<Integer> level = new ArrayList<>();
//            for(int i = j; i < 3; ++i){
//
//                level.add((i + 1) * (i + 1));
//            }
//            text.add(level);
//        }
//        System.out.println(text);
//        List<List<Integer>> newAns = lt.reserve(text);
//        System.out.println(newAns);
//    }


    /*
        上面的代码主要还是依靠102的做法，然后把输出结果反转了一下而已；
        下面的代码当然也是基于102而来的，只不过在添加level节点的时候，不是在尾部添加，而是在头部添加；
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
        }


        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < n; ++i){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(0,level);
        }


        return ans;

    }

}
