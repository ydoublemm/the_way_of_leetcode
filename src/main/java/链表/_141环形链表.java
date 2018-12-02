package 链表;

/**
 * @Author: ymm
 * @Date: 2018/10/25 23:45
 * @Description:
 */



class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }
}
