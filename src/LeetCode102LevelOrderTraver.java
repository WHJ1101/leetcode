import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode102LevelOrderTraver {
    /*
    * 一般来说，层序遍历都可以用BFS来解决；
    * 而BFS又有模板可以套用：
    * 用一个队列来存储节点，
    * 头结点先行入队，
    * 之后，当队列不空的时候：
    * 每进来一个节点，就检查它是否有孩子节点，若有，将其孩子节点入队；
    * 这样，利用队列先进先出的特点，可以很轻松的实现BFS；
    *
    * 本题另外有一点特殊的输出要求：
    * 按层输出：输出一个二维数组，二维数组中每一个元素为该层的节点；而BFS只是简单的输出一个一维数组。
    *
    * 解决办法：
    * 增加一个计数器：n
    * n就是该层节点的个数，比如头结点入队时，n就是1，也就是此时的queue.size；
    * 然后我们在接下来的n步把pop出的节点装入一个临时的一维数组：level
    * 执行完n步之后，再将level装入要返回的结果：ans中，且，此时队列中余下的元素也就是下一层的所有元素。
    * 所以再接下来的循环中，我们依然可以利用n=queue.size来计数；
    * */



    private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            ans.add(level);
        }


        return ans;
    }

}
