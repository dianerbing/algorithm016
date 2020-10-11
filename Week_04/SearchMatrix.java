package wb.test;

public class SearchMatrix {
    //二分查找
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = matrix.length;
        if (x == 0) return false;
        int y = matrix[0].length;
        if (y == 0) return false;
        int begin = 0, end = x * y - 1;
        while (begin <= end) {
            int half = (begin + end) / 2;
            int val = matrix[half / y][half % y];
            if (val == target) {
                return true;
            } else if (val < target) {
                begin = half + 1;
            } else if (val > target) {
                end = half - 1;
            }
        }

        return false;
    }
}
