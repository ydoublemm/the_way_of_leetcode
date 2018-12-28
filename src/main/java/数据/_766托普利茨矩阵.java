package 数据;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

/**
 * @Author: ymm
 * @Date: 2018/12/27 14:09
 * @Description:
 */
class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int xlen = matrix.length;
        int ylen = matrix[0].length;


        for (int x = 0; x < xlen;x++) {
            int i=x;
            int j=0;
            int temp = matrix[i][j];
            while (i < xlen && j < ylen) {
                if (temp != matrix[i][j]) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }

        //从左上角
        for (int y = 0; y < ylen; y++) {
            int i = 0;
            int j = y;
            int temp = matrix[i][j];
            while (i < xlen && j < ylen) {
                if (temp != matrix[i][j]) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }

        return true;
    }
}
/*
* [[44,35,39],[15,44,35],[17,15,44],[80,17,15],[43,80,0],[77,43,80]]
* */
class MainClass766 {
    public static void main(String[] args) {
        int[][] nums = {
                {44,35,39},
                {15,44,35},
                {17,15,44},
                {80,17,15},
                {43,80,0},
                {77,43,80}
        };

        boolean toeplitzMatrix = new Solution766().isToeplitzMatrix(nums);
        System.out.println(toeplitzMatrix+"");
    }
}