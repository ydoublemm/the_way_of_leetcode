package 数据;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: ymm
 * @Date: 2018/12/27 13:43
 * @Description:
 */
class Solution566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int xlen = nums.length;
        int ylen = nums[0].length;
        if (xlen * ylen != r * c) {
            return nums;
        }

        int[][] res = new int[r][c];

        for (int i = 0, x = 0, y = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                if (y < c) {
                    res[x][y++] = nums[i][j];
                } else {
                    x++;
                    y = 0;
                    res[x][y++] = nums[i][j];
                }

            }
        }
        return res;
    }
}

class MainClass566 {
    public static void main(String[] args) throws IOException {
        int[][] nums = {{1, 2}, {3, 4}};
        int r = 4;
        int c = 1;
        new Solution566().matrixReshape(nums, r, c);
    }
}
