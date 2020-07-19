public class LeetCode025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode p = sentinel;
        //ListNode right = p;
        while(p != null){
            ListNode right = p;
            for(int i = 0; i < k; ++i){
                right = right.next;
                if(right == null){
                    return sentinel.next;
                }
            }
            p.next = reverseList(p.next, right);

            for(int i = 0; i < k; ++i){
                p = p.next;
            }

        }
        return sentinel.next;
    }

    private ListNode reverseList(ListNode left, ListNode right){
        if(left == right){
            return left;
        }
        ListNode _next = right.next;

        ListNode pre = right.next;
        ListNode cur = left;
        ListNode tail = cur.next;

        while(cur != _next){
            tail = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tail;
        }
        return pre;
    }
}
