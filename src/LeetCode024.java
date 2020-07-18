public class LeetCode024 {
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode tail = head.next;
        if(tail == null){
            return head;
        }
        while(tail != null){
            ListNode temp = tail.next;

            tail.next = cur;
            cur.next =temp;
            pre.next =tail;

            pre = cur;
            cur = cur.next;
            tail = cur.next;
        }
        return dummy.next;
    }
}
