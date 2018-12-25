package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/25 16:28
 * @Description:
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            int len = A[i].length;
            for (int j = 0; j < len/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][len-j-1];
                A[i][len-j-1] = temp;

                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }

                if (A[i][len - j - 1] == 1) {
                    A[i][len - j - 1] = 0;
                } else {
                    A[i][len-j-1] =1;
                }
            }

            if (len % 2 == 1) {
                if (A[i][len/2] == 1) {
                    A[i][len/2] = 0;
                } else {
                    A[i][len/2] = 1;
                }
            }
        }

        return A;
    }
}