public class ByteDanceFirstInterview01SwapList {

    private class ListNode{
        int val;
        ListNode next;

        ListNode (int val){
            this.val = val;
            next = null;
        }

        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode swapPairs(ListNode head){
        ListNode dummy = new ListNode(-1);
        //dummy.next = head;
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
