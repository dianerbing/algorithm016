package wb.test;

public class BuildTreePreIn {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd) {
        //说明没有子树
        if (inBegin > inEnd) {
            return null;
        }

        //前序遍历的第一个元素就是根节点
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);

        //在中序遍历中找到根节点的位置，根节点前面的就是左子树，后面的是右子树
        int rootPos = 0;
        for (int i = inEnd; i >= inBegin; i--) {
            if (inorder[i] == rootVal) {
                rootPos = i;
                break;
            }
        }

        //递归的去生成左子树和右子树
        //中序遍历结果中，根节点位置前面的数组就是左子树的中序遍历结果，后面的就是右子树的中序遍历结果
        //从中序遍历中可以得到左子树的个数，假设为n
        //前序遍历结果中，除去第一个是根节点，剩余的部分前n个是左子树的前序遍历结果，后面的是右子树的前序遍历结果
        root.left = buildTree(preorder, inorder, preBegin + 1, preBegin + rootPos - inBegin, inBegin, rootPos - 1);
        root.right = buildTree(preorder, inorder, preBegin + rootPos - inBegin + 1, preEnd, rootPos + 1, inEnd);
        return root;
    }
}
