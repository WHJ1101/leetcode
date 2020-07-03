public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        /*
            1.迭代：
                利用三个指针：
                前置节点、当前节点、后继节点；
                每次遍历，当前节点的next指向前置节点、后继节点保存下一个遍历的节点
         */
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode pre = null, cur = head, tail = head.next;
//        while(cur != null){
//            tail = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = tail;
//        }
//        return pre;
        /*
            2.递归：
                baseCase: head == null
                递归还是一看就会，一做就废
         */

        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
