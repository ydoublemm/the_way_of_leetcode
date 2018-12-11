package 链表;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/9 13:36
 * @Description:
 */
class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);

        ListNode head3 = new ListNode(0);
        ListNode dummyHead3 = head3;

        boolean flag = false;//判断是否要进位

        while(head1 != null && head2 != null){

            int val1 = head1.val;
            int val2 = head2.val;
            int val3 = 0;

            //进位
            if (flag) {
                val3 = val1 + val2+1;
            }else {
                val3 = val1 +val2;
            }

            //判断下一步是否要进位
            if(val3 >=10 ){
                val3 = val3%10;
                flag = true;
            }else{
                flag = false;
            }

            ListNode tempHead3 = new ListNode(val3);
            dummyHead3.next = tempHead3;
            dummyHead3 = dummyHead3.next;
            head1 = head1.next;
            head2 = head2.next;
        }

        ListNode tempNode =null;

        //计算几个链表的情况
        if(head1 == null && head2 != null){
            tempNode = head2;
        }else if(head1 != null && head2 ==null){
            tempNode = head1;
        }else {
            if (flag){
               dummyHead3.next = new ListNode(1);
            }
        }

        while (tempNode != null){
            int val3 = 0;
            if(flag){
                tempNode.val= tempNode.val+1;
            }

            if(tempNode.val >= 10){
                tempNode.val = tempNode.val%10;
                flag =true;
            }else {
                flag = false;
            }
            ListNode tempHead3 = new ListNode(tempNode.val);
            dummyHead3.next = tempHead3;
            dummyHead3 = dummyHead3.next;
            tempNode = tempNode.next;
        }

        if (flag){
            dummyHead3.next = new ListNode(1);
        }

        return reverse(head3.next);


    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode preNode = head ;
        head = head.next;
        preNode.next = null;
        ListNode currentNode = head;
        while(currentNode != null){
            ListNode tempNode = currentNode;
            currentNode = currentNode.next;
            tempNode.next = preNode;
            preNode = tempNode;
        }

        return preNode;
    }
}


 class MainClass445 {
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
            ListNode l1 = stringToListNode(line);
            line = in.readLine();
            ListNode l2 = stringToListNode(line);

            ListNode ret = new Solution445().addTwoNumbers(l1, l2);

            String out = listNodeToString(ret);

            System.out.print(out);
        }
    }
}