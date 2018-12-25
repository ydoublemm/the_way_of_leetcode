package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/25 16:09
 * @Description:
 */
class Solution905 {
    public int[] sortArrayByParity(int[] A) {
        int len = A.length;
        for (int i = 0; i < len-1 ; i++) {
            if (A[i] % 2 == 1) {
                int j = i+1;
                while (j < len) {
                    if (A[j] % 2 == 0) {
                        int temp = A[i];
                        A[i] = A[j];
                        A[j] = temp;
                        break;
                    }else {
                        j++;
                    }
                }
            }
        }

        return A;
    }
}