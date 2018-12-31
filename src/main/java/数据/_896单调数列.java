package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/31 15:28
 * @Description:
 */
class Solution896 {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        if (len == 1 || len == 0 || len == 2) {
            return true;
        }

        return isDec(A) || isInc(A);

    }

    public boolean isInc(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public boolean isDec(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            if (a[i] < a[i + 1]) {
                return false;
            }
        }

        return true;
    }
}