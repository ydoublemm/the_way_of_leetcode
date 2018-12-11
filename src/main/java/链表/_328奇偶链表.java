package 链表;

/**
 * @Author: ymm
 * @Date: 2018/12/11 13:12
 * @Description:
 */
//把所有奇数节点和偶数节点都分离出来，在组成新的链表
class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head .next == null ) return head;

        //奇数节点
        ListNode oddHead = head;
        ListNode oddMove = oddHead;
        //偶数节点
        ListNode evenHead = head.next;
        ListNode evenMove = evenHead;

        while(oddMove.next != null && evenMove.next != null){
            oddMove.next = evenMove.next;
            oddMove = oddMove.next;
            evenMove.next = oddMove.next;
            evenMove = evenMove.next;
        }
        oddMove.next = evenHead;
        return oddHead;
    }
}