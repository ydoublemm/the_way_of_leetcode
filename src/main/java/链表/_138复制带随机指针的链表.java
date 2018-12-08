package 链表;

import java.util.HashMap;

/**
 * @Author: ymm
 * @Date: 2018/12/8 14:23
 * @Description:
 * 这题的难点在于 random 可能指向后面的一个node ，在遍历的时候这个node还没有被创建出来
 */
class Solution138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode currentNode = head;
        //把节点所有信息都装进hashmap
        while(currentNode != null){
            RandomListNode temp= new RandomListNode(currentNode.label);
            map.put(currentNode, temp);
            currentNode = currentNode.next;
        }

        currentNode = head ;
        while(currentNode != null){
            RandomListNode node = map.get(currentNode);
            node.next =map.get(currentNode.next);
            node.random = map.get(currentNode.random);

            currentNode =currentNode.next;
        }

        return map.get(head);
    }

}