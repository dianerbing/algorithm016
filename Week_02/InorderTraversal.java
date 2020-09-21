package wb.test;

import java.util.ArrayList;
import java.util.List;

//二叉树中序遍历
public class InorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void dfs(TreeNode root, List<Integer> ans) {
        if (root.left != null) {
            dfs(root.left, ans);
        }

        ans.add(root.val);

        if (root.right != null) {
            dfs(root.right, ans);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        List<Integer> ans = new ArrayList<>();
        dfs(root, ans);
        return ans;
    }
}
