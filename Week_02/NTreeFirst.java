package wb.test;

import java.util.ArrayList;
import java.util.List;

//N叉树的前序遍历
public class NTreeFirst {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public void first(Node root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);

            for (Node node : root.children) {
                first(node, list);
            }
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        first(root, list);
        return list;
    }
}
