package wb.test;

import java.util.Arrays;

public class MaxSumSubmatrix {
    /**
     * 363. 矩形区域不超过 K 的最大数值和
     * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        //枚举左右边界
        int maxLessK = Integer.MIN_VALUE;
        int[] rowSum = new int[matrix.length];
        for (int left = 0; left < matrix[0].length; left++) {
            Arrays.fill(rowSum, 0);
            for (int right = left; right < matrix[0].length; right++) {
                //转化为最大子序和的问题
                int pre = 0, max = 0;
                for (int i = 0; i < rowSum.length; i++) {
                    rowSum[i] += matrix[i][right];
                    if (i == 0) {
                        pre = rowSum[0];
                        max = pre;
                    } else {
                        pre = Math.max(pre + rowSum[i], rowSum[i]);
                        max = Math.max(pre, max);
                    }
                }

                //如果最大子序和不大于k，直接返回最大子序和
                if (max <= k) {
                    maxLessK = Math.max(maxLessK, max);
                    continue;
                }
                //否则，暴力求解可能的最大值（因为最大子序和超过K值后，子序和不大于K值的就要重新求解）
                for (int i = 0; i < rowSum.length; i++) {
                    max = 0;
                    for (int j = i; j < rowSum.length; j++) {
                        max += rowSum[j];
                        if (max <= k) {
                            maxLessK = Math.max(maxLessK, max);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        return maxLessK;
    }
}
