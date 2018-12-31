package 数据;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: ymm
 * @Date: 2018/12/28 20:30
 * @Description:
 */
class Solution119 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new LinkedList<>();


        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(1);

        if (rowIndex == 0) {
            res.add(list1);
        } else if (rowIndex == 1) {
            res.add(list1);
            res.add(list2);
        }  else {
            res.add(list1);
            res.add(list2);
            for (int i = 2; i <= rowIndex; i++) {
                List<Integer> last = ((LinkedList<List<Integer>>) res).getLast();
                List<Integer> list = new LinkedList();
                for (int j = 0; j < i+1; j++) {
                    if (j == 0) {
                        list.add(1); 
                    } else if (j == i ) {
                        list.add(1);
                        res.add(list);
                    } else {
                        list.add(last.get(j - 1) + last.get(j));
                    }
                }
            }
        }

        return res.get(rowIndex);
    }
}

 class MainClass119 {
    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int rowIndex = Integer.parseInt(line);

            List<Integer> ret = new Solution119().getRow(rowIndex);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}