import java.util.HashSet;
import java.util.Set;

public class LeetCode141 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    /*
        哈希表：
        集合里存放的是node节点的引用，也可以说是地址；
        所以只有同一个节点才会被集合视为重复元素；
        而如果只是节点中的值相同的话，在集合看来两个节点并不相同（地址不一样）
    */
//    public boolean hasCycle(ListNode head) {
//        Set<ListNode> nodeSet = new HashSet<>();
//        ListNode p = head;
//        while(p != null){
//            if(nodeSet.contains(p)){
//                return true;
//            }
//            nodeSet.add(p);
//            p = p.next;
//        }
//        return false;
//    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

}
