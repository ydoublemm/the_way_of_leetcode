package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/5 0:39
 * @Description:
 */
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        //slowNode移动到中间节点或者中间节点的前一个节点
        while(fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode =fastNode.next.next;
        }
        Stack<Integer> stack = new Stack();
        slowNode = slowNode.next;
        while (slowNode != null){
            stack.push(slowNode.val);
            slowNode = slowNode.next;
        }
        ListNode tempNode =head;
        while (!stack.empty()){
            if(tempNode.val != stack.pop()){
                return false;
            }
            tempNode = tempNode.next;
        }

        return true;
    }
}

 class MainClass234 {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            boolean ret = new Solution234().isPalindrome(head);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}