package wb.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 *https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairs {
    //递归+缓存
    private Map<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int res = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, res);
        return res;
    }
}
