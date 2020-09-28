package wb.test;

public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件：root为null，返回null；如果root就是p或q，直接返回root
        //需要注意的是，如果root非空，此root可能就是最近公共节点了，例如leetcode题目上的示例2
        if (root == null || root.val == p.val || root.val == q.val) return root;

        //如果root不是目标节点p或q，则在其左右子树中查找p或q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //如果left返回的是空，说明左子树中没有p或q
        //说明p和q一定都在右子树中，则以右侧返回的结果作为最终结果
        if (left == null) return right;
        //道理同上
        if (right == null)  return left;

        //如果左右两侧都不为空，说明q和q分别落在当前节点的左右子树上，此节点就是pq的最近公共节点了
        //因为根据二叉树的特性，pq只会落在“非最近公共节点”的一侧上，只有最近公共节点可能会分布在左右两侧
        return root;
    }
}
