import java.util.HashMap;

public class LeetCode083 {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if( head == null){
            return null;
        }
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode p =head;
        ListNode pNext = head.next;
        map.put(p.val, p);
        while(pNext != null){
            if(map.containsKey(pNext.val)){
                p.next = pNext.next;
                pNext.next = null;

            }else {
                map.put(pNext.val, pNext);
                p = pNext;
            }

            pNext = p.next;
        }
        return head;
    }
}
