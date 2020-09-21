package wb.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    //迭代写法 1
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode node = stack.pop();
                ans.add(node.val);
                root = node.right;
            }
        }

        return ans;
    }

    //迭代写法 2
    public List<Integer> inorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }

        return ans;
    }
}
