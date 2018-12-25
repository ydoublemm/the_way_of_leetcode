package 链表;

/**
 * @Author: ymm
 * @Date: 2018/12/13 23:12
 * @Description:
 */
//要自己画图，不然理不清楚
class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode mPreNode = findNodeByNum(dummyNode, m-1);

        //移动的
        ListNode mNode = mPreNode.next;
        //暂存
        ListNode tempMnode = mNode;

        ListNode currentNode = mNode.next;

        for (int i = 0; currentNode != null && i < n - m; i++) {
            ListNode tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = mNode;
            mNode = tempNode;
        }

        mPreNode.next = mNode;
        tempMnode.next =  currentNode;

        return dummyNode.next;
    }

    public ListNode findNodeByNum(ListNode head, int n) {
        int count = 0;
        while (count < n) {
            head = head.next;
            count++;
        }
        return head;

    }


}
