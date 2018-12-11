package 链表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/12/11 13:47
 * @Description:
 */
class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = getLength(root);
        ListNode[] nodeArr = new ListNode[k];
        //有null的情况
        if(length < k){
            for (int i=0,j=0; i<k ; i++,j++){
                if(j < length){
                    Map<String, ListNode> map = getParts(root, 1);
                    nodeArr[i] = map.get("partsHead");
                    root = map.get("head");
                }else{
                    nodeArr[i] = null;
                }
            }
        }else {
            //多余的节点
            int n = length % k;
            //每次最少分几个节点
            int m = length / k;
            for (int i=0,j=0; i<k ; i++,j++){
                if(j < n) {
                    Map<String, ListNode> map = getParts(root, m+1);
                    nodeArr[i] = map.get("partsHead");
                    root = map.get("head");
                }else{
                    Map<String, ListNode> map = getParts(root, m);
                    nodeArr[i] = map.get("partsHead");
                    root = map.get("head");
                }
            }
        }
        return nodeArr;
    }

    public int getLength(ListNode root){
        int count=0;
        while(root != null){
            count ++;
            root = root.next;
        }
        return count;
    }

    public Map<String,ListNode> getParts(ListNode root , int n){
        ListNode dummyHead = root;
        int count =1;
        HashMap<String,ListNode> map = new HashMap<>();
        while(count < n){
            dummyHead = dummyHead.next;
            count++;
        }
        ListNode partsHead = root;
        ListNode head = dummyHead.next;
        dummyHead.next = null;

        //分离出去的节点
        map.put("partsHead", partsHead);
        //剩下的节点
        map.put("head", head);

        return map;
    }
}