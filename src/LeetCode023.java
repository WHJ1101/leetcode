public class LeetCode023 {
    /*
        两两合并：
        第一轮，将k个链表两两合并（奇数时，最后一个为其本身），合并出的k/2个新链表可以在原地存储（可以覆盖原数组）；
        第二轮，将上轮的结果：k/2个链表继续两两合并，得到k/4个新链表，仍然原地储存；

        总共进行log(k)轮合并，最后的结果储存在lists[0]处，返回即可
     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        int k = lists.length;
//        if(k == 0){
//            return null;
//        }
//
//        while(k > 1){
//            int index = 0;
//            for(int i = 0; i < k; i += 2){
//                if(i == k - 1){
//                    lists[index++] = lists[i];
//                }else{
//                    lists[index++] = mergeTwoLists(lists[i], lists[i + 1]);
//                }
//            }
//            k = index;
//        }
//        return lists[0];
//
//    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0){
            return null;
        }

        while(k > 1){
            int index = 0;
            for(int i = 0; i < k; i += 2){
                if(i == k - 1){
                    lists[index++] = lists[i];
                }else{
                    lists[index++] = mergeTwoLists(lists[i], lists[i + 1]);
                }
            }
            k = index;
        }
        return lists[0];

    }







    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
