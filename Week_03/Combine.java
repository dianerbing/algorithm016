package wb.test;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ansOne = new ArrayList<>();
        recurse(n, k, 1, ansOne, ans);
        return ans;
    }

//    //回溯 + 不剪枝  20+毫秒
//    public static void recurse(int n, int k, int i, List<Integer> ansOne, List<List<Integer>> ans) {
//        if (ansOne.size() == k) {
//            ans.add(new ArrayList<>(ansOne));
//            return;
//        }
//        for (; i <= n; i++) {
//            ansOne.add(i);
//            recurse(n, k, i+1, ansOne, ans);
//            ansOne.remove(ansOne.size()-1);
//        }
//    }

    //回溯 + 剪枝   2毫秒
    public static void recurse(int n, int k, int i, List<Integer> ansOne, List<List<Integer>> ans) {
        if (ansOne.size() == k) {
            ans.add(new ArrayList<>(ansOne));
            return;
        }

        //k - ansOne.size - 1 是给下一层递归留出的空间！
        for (; i <= n - (k - ansOne.size() - 1); i++) {
            ansOne.add(i);
            recurse(n, k, i + 1, ansOne, ans);
            ansOne.remove(ansOne.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        List<List<Integer>> res = combine(n, k);
        System.out.println(res);
    }
}
