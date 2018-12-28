package 数据;

/**
 * @Author: ymm
 * @Date: 2018/12/26 10:45
 * @Description:
 */
class Solution867 {
    public int[][] transpose(int[][] a) {
        int xlen = a.length;
        int ylen = a[0].length;
        int[][] b  = new int[ylen][xlen];

        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                b[j][i] = a[i][j];
            }
        }
        return b;


    }
}