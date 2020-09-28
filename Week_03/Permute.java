package wb.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/submissions/
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ansOne = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        for (int val : nums) ansOne.add(val);
        recurse(ansOne, 0, nums.length, ans);

        return ans;
    }

    //递归 + 回溯
    public void recurse(List<Integer> ansOne, int id, int len, List<List<Integer>> ans) {
        //递归终止条件：所有位置都尝试了
        if (len == id) {
            ans.add(new ArrayList<>(ansOne));
            return;
        }

        //不停的尝试索引为id的元素的值
        for (int i = id; i < len; i++) {
            //原地交换，将id位置的值替换为i位置的值
            Collections.swap(ansOne, id, i);
            //递归下一层
            recurse(ansOne, id + 1, len, ans);
            //换回
            Collections.swap(ansOne, id, i);
        }
    }

//自己写的第一版解法，用了hashset做重复校验
// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<Integer> ansOne = new ArrayList<>();
//         List<List<Integer>> ans = new ArrayList<>();
//         dfs(nums, new HashSet<Integer>(), ansOne, ans);
//         return ans;
//     }

//     public void dfs(int[] nums, HashSet<Integer> set, List<Integer> ansOne, List<List<Integer>> ans) {
//         if (ansOne.size() == nums.length) {
//             ans.add(new ArrayList<>(ansOne));
//             return;
//         }

//         for (int i = 0; i<nums.length; i++) {
//             if (!set.contains(nums[i])) {
//                 ansOne.add(nums[i]);
//                 set.add(nums[i]);
//                 dfs(nums, set, ansOne, ans);
//                 set.remove(nums[i]);
//                 ansOne.remove(ansOne.size() - 1);
//             }
//         }
//     }
// }

//官方解法
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();

//         List<Integer> output = new ArrayList<Integer>();
//         for (int num : nums) {
//             output.add(num);
//         }

//         int n = nums.length;
//         backtrack(n, output, res, 0);
//         return res;
//     }

//     public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
//         // 所有数都填完了
//         if (first == n) {
//             res.add(new ArrayList<Integer>(output));
//         }
//         for (int i = first; i < n; i++) {
//             // 动态维护数组
//             Collections.swap(output, first, i);
//             // 继续递归填下一个数
//             backtrack(n, output, res, first + 1);
//             // 撤销操作
//             Collections.swap(output, first, i);
//         }
//     }
// }


//直接用数组原地交换
//     List<List<Integer>> ans=new ArrayList();
//     public List<List<Integer>> permute(int[] nums) {
//         dfs(0,nums);
//         return ans;
//     }
//     public void dfs(int start,int nums[])
//     {
//         if(start==nums.length)
//         {
//             List<Integer> cur=new ArrayList();
//             for(int i:nums)
//                 cur.add(i);
//             ans.add(cur);
//             return;
//         }
//         for(int i=start;i<nums.length;i++)
//         {
//             int temp=nums[i];
//             nums[i]=nums[start];
//             nums[start]=temp;

//             dfs(start+1,nums);

//              temp=nums[i];
//             nums[i]=nums[start];
//             nums[start]=temp;
//         }
//     }
}
