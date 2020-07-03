public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == null && tempB == null){
                return null;
            }
            if(tempA == null){
                tempA = headB;
            }
            if(tempB == null){
                tempB = headA;
            }

        }
        return tempA;

    }
}
