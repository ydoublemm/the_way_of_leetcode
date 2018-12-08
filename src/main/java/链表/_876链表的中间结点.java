package 链表;

/**
 * @Author: ymm
 * @Date: 2018/12/7 19:47
 * @Description:
 */
class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while(fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        if(fastNode.next != null){//偶数个节点
            slowNode = slowNode.next;
        }

        return slowNode;
    }
}