public class LeetCode021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head, tail, a, b;
        head = new ListNode(-1);
        tail = head;
        a = l1;
        b = l2;
        while (a != null && b != null){
            if (a.val <= b.val){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        }else {
            tail.next = a;
        }
        return head.next;

    }
}
