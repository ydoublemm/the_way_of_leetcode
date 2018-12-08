package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/8 17:02
 * @Description:
 */
class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head ;

        //多增加一个节点，方便在头节点之前插入的情况
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        //第一个节点默认有序
        ListNode currentNode = head.next;
        ListNode preNode = head;
        while(currentNode != null){
            ListNode insertPreNode = findInsertPreNode(dummyHead, currentNode);

            //不需要交换的情况
            if(insertPreNode == preNode){
                preNode = preNode.next;
                currentNode = currentNode.next;
            }else{
                //删除curr这个节点
                preNode.next = currentNode.next;
                //把curr插入到insertPreNode后面
                currentNode.next = insertPreNode.next;
                insertPreNode.next = currentNode;

                currentNode = preNode.next;
            }
        }
        return dummyHead.next;
    }

    //找到需要插入节点的前一个节点
    public ListNode findInsertPreNode(ListNode head,ListNode curr){
        while(head.next != curr){
            if(curr.val < head.next.val)
                return head;

            head = head.next;
        }
        //如果上面没有返回，就不要交换
        return head;
    }
}

class MainClass147 {
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

            ListNode ret = new Solution147().insertionSortList(head);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}