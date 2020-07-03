import java.util.HashMap;

public class LeetCode_InterView02_01 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode removeDuplicateNodes(ListNode head) {
        if(head == null){
            return null;
        }
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode p = head;
        ListNode pNext = p.next;
        map.put(p.val,p);
        while(pNext != null) {
            if (map.containsKey(pNext.val)) {
                p.next = pNext.next;
            }else{
                map.put(pNext.val, pNext);
                p = pNext;
            }


            pNext = pNext.next;

        }
        return head;
    }
}
