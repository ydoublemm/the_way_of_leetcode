package 链表;

/**
 * @Author: ymm
 * @Date: 2018/12/2 23:39
 * @Description:
 */
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = ListNodeLength(headA);
        int lenB = ListNodeLength(headB);
        int len = Math.abs(lenA-lenB);

        if(lenA > lenB){
            for(int i=0;i<len;i++){
                headA = headA.next;
            }
        }else {
            for(int i=0;i<len;i++){
                headB = headB.next;
            }
        }

        while(headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int ListNodeLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}