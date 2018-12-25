package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/13 22:27
 * @Description:
 */
class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode preNode = dummyHead;

        while(preNode.next != null && preNode.next.next != null){
            ListNode currentNode = preNode.next;
            ListNode nextNode = preNode.next.next;
            //说明有相同的数据
            if(currentNode.val == nextNode.val){
                ListNode tempNode = currentNode;
                int val = tempNode.val;
                while(tempNode != null && tempNode.val == val){
                    preNode.next = tempNode.next;
                    tempNode = null;
                    tempNode = preNode.next;
                }
            }else {
                preNode = preNode.next;
            }
        }
        return dummyHead.next;
    }
}

class MainClass82 {
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

            ListNode ret = new Solution82().deleteDuplicates(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}