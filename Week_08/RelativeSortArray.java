package wb.test;

public class RelativeSortArray {
    /**
     * 1122. 数组的相对排序
     * https://leetcode-cn.com/problems/relative-sort-array/
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] ans = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            bucket[arr1[i]]++;
        }

        int id = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (bucket[arr2[i]]-- > 0) ans[id++] = arr2[i];
        }
        for (int i = 0; i < 1001; i++) {
            while (bucket[i]-- > 0) ans[id++] = i;
        }

        return ans;
    }
}
