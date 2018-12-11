package 链表;

/**
 * @Author: ymm
 * @Date: 2018/12/11 14:33
 * @Description:
 */
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode addHead = new ListNode(0);
        ListNode dummyHead = addHead;
        boolean flag = false; //是否要进位
        while (head1 != null && head2 != null){
            int sum = head1.val+head2.val;
            if(flag){
                sum +=1;
            }

            if(sum >= 10){
                sum %=10;
                flag = true;
            }else{
                flag = false;
            }

            dummyHead.next = new ListNode(sum);
            dummyHead = dummyHead.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        ListNode tempNode =null;
        if(head1 == null && head2 !=null){
            tempNode = head2;
        }else if(head1 != null && head2 ==null){
            tempNode = head1;
        }else {
            if(flag){
                dummyHead.next = new ListNode(1);
                dummyHead.next.next = null;
            }
        }

        while(tempNode != null){
            int sum = tempNode.val;
            if(flag){
                sum +=1;
            }

            if(sum >= 10){
                sum %=10;
                flag = true;
            }else{
                flag = false;
            }

            dummyHead.next = new ListNode(sum);
            dummyHead = dummyHead.next;
            tempNode = tempNode.next;
        }

        if(flag){
            dummyHead.next = new ListNode(1);
            dummyHead.next.next = null;
        }

        return addHead.next;
    }
}