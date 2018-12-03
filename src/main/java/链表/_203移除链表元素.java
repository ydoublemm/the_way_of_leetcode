package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/2 23:47
 * @Description:
 */
class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        if (head.val == val) {
           head = head.next;
        }

        if(head != null) {
            ListNode currNode = head.next;
            ListNode preNode = head;
            //没有考虑到第一个节点的情况
            while (currNode.next != null) {
                if (currNode.val == val) {
                    preNode.next = preNode.next.next;
                    //因为删除了一个节点，要多移动一次
                    currNode = currNode.next;
                }
                currNode = currNode.next;
                preNode = preNode.next;
            }

            if (currNode.val == val) {
                preNode.next = null;
            }
        }

        return head;
    }
}

class MainClass203 {
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
            int val = Integer.parseInt(line);

            ListNode ret = new Solution203().removeElements(head, val);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}