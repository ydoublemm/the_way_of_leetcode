package 栈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/23 18:00
 * @Description:
 */

/*
* 所以我们只能从下标考虑，就是我只记录我的索引，不涉及真正的字符串的空间，因为字符的操作是有规律的，只要找到其中的规律，我们就可以只通过索引来确定最终字符串的某个字符。

首先我们也是要一个个遍历，如果是字母，就将索引+1，如果碰到数字，就将这个索引乘以这个数字，当然同时要判断，索引与K的关系。如果索引小于K，就一直遍历下去，如果大于等于K，那么就不用了，这个时候我们可以找到第K个元素了。

这个时候要将索引往回退，如果是数字，就要除以这个数字，变成单倍数的字符串，相应的，第K个也要变成单倍数的*/
class Solution880 {
    public String decodeAtIndex(String S, int K) {
        int len = S.length();
        long count = 0;
        int pos = 0;
        //计算字符串长度
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) >= '0' && S.charAt(i) <= '9') {
                count *= (int) (S.charAt(i) - '0');
            } else {
                count++;
            }

            if (count >= K) {
                pos = i;
                break;
            }
        }

        //缩减字符串
        while (pos >= 0) {
            if (S.charAt(pos) >= '0' && S.charAt(pos) <= '9') {
                count /= S.charAt(pos) - '0';
                K %= count;
            } else if ( K %  count == 0) {
                return S.charAt(pos) + "";
            } else {
                count--;
            }

            pos--;
        }

        return null;
    }
}

class MainClass880{
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);
            line = in.readLine();
            int K = Integer.parseInt(line);

            String ret = new Solution880().decodeAtIndex(S, K);

            String out = (ret);

            System.out.print(out);
        }
    }
}