package wb.test;

import java.util.Arrays;

public class Merge {
    /**
     * 56. 合并区间
     * https://leetcode-cn.com/problems/merge-intervals/
     */
    public int[][] merge(int[][] intervals) {
         //先排序，再合并
         //手写，插入排序很慢
         // for (int i = 0; i < intervals.length - 1; i++) {
         //     for (int j = i + 1; j < intervals.length; j++) {
         //         if (intervals[i][0] > intervals[j][0]) {
         //             int tmp0 = intervals[i][0], tmp1 = intervals[i][1];
         //             intervals[i][0] = intervals[j][0];
         //             intervals[i][1] = intervals[j][1];
         //             intervals[j][0] = tmp0;
         //             intervals[j][1] = tmp1;
         //         }
         //     }
         // }

         //利用java自带数组排序
         Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

         int l = 0, r = 1, len = 0;
         int[][] ans = new int[intervals.length][2];
         while (r < intervals.length) {
             if (intervals[l][1] >= intervals[r][0]) {
                 intervals[l][1] = Math.max(intervals[l][1], intervals[r][1]);
                 r++;
             } else {
                 ans[len++] = intervals[l];
                 l = r;
                 r = l + 1;
             }
         }
         if (l < intervals.length) ans[len++] = intervals[l];

         return Arrays.copyOf(ans, len);
    }
}
