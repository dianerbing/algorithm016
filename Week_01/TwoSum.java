class TwoSum {
    //一遍hash
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int curVal = nums[i];
            int othVal = target - curVal;
            if (map.containsKey(othVal)) {
                ans[0] = map.get(othVal);
                ans[1] = i;
                break;
            } else {
                map.put(curVal, i);
            }
        }

        return ans;
    }
}