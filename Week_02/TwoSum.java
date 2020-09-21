package wb.test;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //1. 暴力解法
    public int[] twoSum0(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }

        return ans;
    }

    //2. 两次hash遍历
    public int[] twoSum1(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res) && map.get(res)!=i) {
                ans[0] = i;
                ans[1] = map.get(res);
                break;
            }
        }

        return ans;
    }

    //3. 一次hash遍历
    public int[] twoSum2(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int res = target - nums[i];
            if (map.containsKey(res)) {
                ans[0] = map.get(res);
                ans[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return ans;
    }
}
