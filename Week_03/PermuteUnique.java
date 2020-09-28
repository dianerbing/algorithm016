package wb.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> ansOne = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        Arrays.sort(nums);
        recurse(nums, visited, ansOne, ans);
        return ans;
    }

    public void recurse(int[] nums,  boolean[] visited, List<Integer> ansOne, List<List<Integer>> ans) {
        if (ansOne.size() == nums.length) {
            ans.add(new ArrayList<>(ansOne));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i-1] && !visited[i-1])) {
                continue;
            }

            ansOne.add(nums[i]);
            visited[i] = true;
            recurse(nums, visited, ansOne, ans);
            visited[i] = false;
            ansOne.remove(ansOne.size()-1);
        }
    }

//    //在原来递归和回溯的基础上，增加了排序和去重
//    public List<List<Integer>> permuteUnique(int[] nums) {
//        List<Integer> ansOne = new ArrayList<>();
//        List<List<Integer>> ans = new ArrayList<>();
//
//        Arrays.sort(nums);
//        for (int val : nums) ansOne.add(val);
//        recurse(ansOne, 0, nums.length, ans);
//
//        return ans;
//    }
//
//    //递归 + 回溯
//    public void recurse(List<Integer> ansOne, int id, int len, List<List<Integer>> ans) {
//        //递归终止条件：所有位置都尝试了
//        if (len == id) {
//            ans.add(new ArrayList<>(ansOne));
//            return;
//        }
//
//        //不停的尝试索引为id的元素的值
//        for (int i = id; i < len; i++) {
//            if (i > id && ansOne.get(i) == ansOne.get(i-1)) {
//                continue;
//            }
//            //原地交换，将id位置的值替换为i位置的值
//            ansOne.add(id, ansOne.get(i));
//            ansOne.remove(i+1);
//            //递归下一层
//            recurse(ansOne, id + 1, len, ans);
//            //换回
//            ansOne.add(i+1, ansOne.get(id));
//            ansOne.remove(id);
//        }
//    }
}
