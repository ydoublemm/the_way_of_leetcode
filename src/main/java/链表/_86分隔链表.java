package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/14 2:20
 * @Description:
 */
class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummyHead = new ListNode(Integer.MIN_VALUE);
        dummyHead.next = head;

        ListNode slow = dummyHead;
        ListNode fast = dummyHead;

        //找到第一个节点大于x的前一个节点
        while (slow.next != null && slow.next.val < x) {
            slow = slow.next;
        }

        //
        fast = slow.next;
        while (fast != null && fast.next != null) {
            if (fast.next.val < x) {
                //删除后面的节点
                ListNode fastNext = fast.next;
                fast.next = fastNext.next;

                //插入节点
                ListNode slowNext = slow.next;
                slow.next = fastNext;
                fastNext.next = slowNext;

                //移动slow
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }

        return dummyHead.next;
    }
}

class MainClass86 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            line = in.readLine();
            int x = Integer.parseInt(line);

            ListNode ret = new Solution86().partition(head, x);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}