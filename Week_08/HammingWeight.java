package wb.test;

public class HammingWeight {
    /**
     * 191. 位1的个数
     * https://leetcode-cn.com/problems/number-of-1-bits/
     */
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // int ans = 0, i = 32;
        // while (i-- > 0) {
        //     if ((n & 1) == 1) ans++;
        //     n >>= 1;
        // }
        // return ans;
        int  ans = 0,mask = 1;
        for (int i=0;i<32;i++){
            if ((n&mask) !=0)  ans++;
            mask<<=1;
        }
        return  ans;
    }
}
