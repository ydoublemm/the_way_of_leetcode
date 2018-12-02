package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/11/30 23:26
 * @Description:
 */


class Solution142 {




    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode fastNode = head;
        ListNode slowNode = head;


        while (fastNode.next !=null && fastNode.next.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            //相遇表示有环
            if(fastNode == slowNode){
                break;
            }
        }

        //说明有环
        if(fastNode.next != null && fastNode.next.next != null) {
            slowNode = head;
            while (slowNode != fastNode) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            }
            return slowNode;
        }

        return null;


    }
}

class MainClass142 {
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

            ListNode ret = new Solution142().detectCycle(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}