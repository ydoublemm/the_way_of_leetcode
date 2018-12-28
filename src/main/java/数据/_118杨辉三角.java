package 数据;

import 链表.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ymm
 * @Date: 2018/12/26 12:26
 * @Description:
 */
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();


        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(1);

        if (numRows == 0) {

        } else if (numRows == 1) {
            res.add(list1);
        } else if (numRows == 2) {
            res.add(list1);
            res.add(list2);
        } else {
            res.add(list1);
            res.add(list2);
            for (int i = 3; i <= numRows; i++) {
                List<Integer> last = ((LinkedList<List<Integer>>) res).getLast();
                List<Integer> list = new LinkedList();
                for (int j = 0; j < i; j++) {
                    if (j == 0) {
                        list.add(1);
                    } else if (j == i - 1) {
                        list.add(1);
                        res.add(list);
                    } else {
                        list.add(last.get(j - 1) + last.get(j));
                    }
                }
            }
        }

        return res;
    }
}

class MainClass118 {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static String int2dListToString(List<List<Integer>> nums) {
        StringBuilder sb = new StringBuilder("[");
        for (List<Integer> list : nums) {
            sb.append(integerArrayListToString(list));
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int numRows = Integer.parseInt(line);

            List<List<Integer>> ret = new Solution118().generate(numRows);

            String out = int2dListToString(ret);

            System.out.print(out);
        }
    }
}