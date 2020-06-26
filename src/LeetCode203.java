public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null || (head.next == null && head.val == val)){
            return null;
        }
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode p = sentinel;
        ListNode pNext = p.next;
        while (pNext != null){
            if(pNext.val == val){
                p.next = pNext.next;
                pNext.next = null;
            }else{
                p = pNext;
            }
            pNext = p.next;
        }
        return sentinel.next;

    }
}
