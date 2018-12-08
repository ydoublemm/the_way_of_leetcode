package 链表;

/**
 * @Author: ymm
 * @Date: 2018/12/6 23:29
 * @Description:
 */
class MyLinkedList {

    class Entry {
        int val;
        Entry next;

        public Entry() {

        }
    }

    Entry head = null;
    int size = 0;


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    //index都是从0开始的

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Entry currentNode = head;
        int count = 0;
        while (count < index) {
            count++;
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Entry t = new Entry();
        t.next = head;
        t.val = val;
        head = t;

        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        int count = 0;
        Entry t = head;
        //找到最后一个节点
        while (count < size - 1) {
            t = t.next;
            count++;
        }
        Entry newNode = new Entry();
        newNode.next = null;
        newNode.val = val;
        t.next = newNode;

        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        } else {
            int count = 0;
            Entry preNode = head;
            //找到当前节点的前一个节点
            while (count < index - 1) {
                preNode = preNode.next;
                count++;
            }
            Entry currentNode = preNode.next;
            Entry newNode = new Entry();
            newNode.val = val;
            preNode.next = newNode;
            newNode.next = currentNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;

        if (index == 0) {
            Entry t = head;
            head = head.next;
            t = null;
        } else {
            int count = 0;
            Entry preNode = head;
            //找到前一个节点
            while (count < index - 1) {
                preNode = preNode.next;
                count++;
            }
            Entry currentNode = preNode.next;
            preNode.next = currentNode.next;
            currentNode = null;
        }
        size--;
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[ " + get(0));
            int index = 1;
            while (index < size) {
                sb.append(" --> " + get(index));
                index++;
            }
            sb.append(" ]");
            return sb.toString();
        }

    }
}

class mainClass707 {
    /*
    ["MyLinkedList",[]
    "get",[0]
    "addAtIndex",[1,2]
    "get",[0]
    "get",[1]
    "addAtIndex",[0,1]
    "get",[0]
    "get"],[1]
    */
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.get(0);
        linkedList.addAtIndex(1, 2);
        linkedList.get(0);
        linkedList.get(1);
        linkedList.addAtIndex(0, 1);
        linkedList.get(0);
        linkedList.get(1);
    }
}



