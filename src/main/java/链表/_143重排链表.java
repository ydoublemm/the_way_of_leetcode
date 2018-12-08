package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/8 16:08
 * @Description:
 */
class Solution143 {
    //这个方法是找每次都找最后第二个节点，然后找到最后一个节点，插入到前面 O(n^2)
    //另一个更好的方法是找到中间节点，反转后面的节点，然后把后面的节点插入到前面 O(n)
    public void reorderList(ListNode head) {
        int count = 0;
        ListNode currentNode = head ;
        while (currentNode != null){
            count++;
            currentNode =currentNode.next;
        }
        currentNode = head;
        for(int i=0;i<count/2;i++){
            ListNode secondLast = findSecondLast(currentNode);
            ListNode last = secondLast.next;
            secondLast.next = null;

            //交换
            ListNode currentNext = currentNode.next;
            currentNode.next = last;
            last.next = currentNext;

            currentNode = currentNode.next.next;
        }

    }

    //找到最后第二个节点
    public ListNode findSecondLast(ListNode head){
        while (head.next.next != null){
            head = head.next;
        }
        return head;
    }
}

class MainClass143 {
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

            new Solution143().reorderList(head);
            String out = listNodeToString(head);

            System.out.print(out);
        }
    }
}