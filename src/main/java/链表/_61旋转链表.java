package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/14 3:33
 * @Description:
 */
class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode dummyHead = head;

        //总结点数
        int count = 1;
        //找到最后一个节点
        while (dummyHead.next != null) {
            count++;
            dummyHead = dummyHead.next;
        }
        //形成环
        dummyHead.next = head;

        //如果循环多次，取模
        k = k % count;

        int n = 0;
        while (n < count - k) {
            head = head.next;
            n++;
        }

        //解环
        ListNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = null;

        return head ;
    }
}

 class MainClass61 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
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
        for(int item : nodeValues) {
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
            int k = Integer.parseInt(line);

            ListNode ret = new Solution61().rotateRight(head, k);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}