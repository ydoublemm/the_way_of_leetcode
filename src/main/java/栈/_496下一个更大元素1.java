package 栈;


import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: ymm
 * @Date: 2018/12/19 14:39
 * @Description:
 */

/*
* 这题可以用两个循环来完成，时间复杂度是O(n^2)
* 但是用栈和map 结合来做 时间复杂度为O(n)
* 思路：因为不知道下一个比当前元素大的值在哪里，所以用栈存起来
*       然后去比较，找到就出栈，这里的栈提供了一个倒叙检索的功能
* */
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap();
        Stack<Integer> stack = new Stack<>();

        for(int num2 :nums2){
            //栈在这里提供了一个倒叙检索的作用
            while (!stack.empty() && stack.peek() < num2){
                map.put(stack.pop(), num2);
            }
            stack.push(num2);
        }

        for (int i = 0; i<nums1.length;i++ ) {
            Integer num = map.get(nums1[i]);
            if(num != null){
                res[i] = num;
            }else{
                res[i] = -1;
            }
        }
        return res;
    }
}