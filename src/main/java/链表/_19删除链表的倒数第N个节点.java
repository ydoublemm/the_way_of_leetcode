package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/12 22:47
 * @Description:
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;

        //方便删除头节点的情况
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slowNode = dummyNode;
        ListNode fastNode = dummyNode;

        int count = 0;
        while (count < n) {
            fastNode = fastNode.next;
            count++;
        }

        //找到要删除节点的前一个节点
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        ListNode delNode = slowNode.next;
        slowNode.next = delNode.next;
        delNode = null;

        return dummyNode.next;
    }
}

class MainClass19 {
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
            int n = Integer.parseInt(line);

            ListNode ret = new Solution19().removeNthFromEnd(head, n);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}