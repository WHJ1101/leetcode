import java.util.LinkedList;
import java.util.Queue;

public class LeetCode297 {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /*
            between tree:[]
            between node: ,
            node: if val != null: val
                  else : "null"
         */
        StringBuilder ans = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            if(cur == null){
                ans.append("null,");
            }else {
                ans.append(cur.val + ",");
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }

        ans.setLength(ans.length() - 1);
        ans.append("]");

        return ans.toString();


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1,data.length()-1).split(",");
        TreeNode root = getNode(nodes[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        TreeNode parent =root;
        boolean isLeft = true;

        for(int i = 1; i < nodes.length; ++i){
            TreeNode cur = getNode(nodes[i]);
            if(isLeft){
                parent.left = cur;
            }else{
                parent.right= cur;
            }
            if(cur != null){
                parents.add(cur);
            }
            isLeft = !isLeft;
            if(isLeft){
                parent = parents.poll();
            }
        }

        return root;

    }

    private TreeNode getNode(String val){
        if(val.equals("null")){
            return null;
        }
        return new TreeNode(Integer.parseInt(val));
    }

}
