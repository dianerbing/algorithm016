package wb.test;

public class IsPowerOfTwo {
    /**
     * 231. 2的幂
     * https://leetcode-cn.com/problems/power-of-two/
     */
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;

        //判断二进制位中只有1个1
        int cnt = 0, i = 32;
        while (i-- > 0 && cnt < 2) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n >>= 1;
        }

        return cnt == 1;
    }
}
