package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 20/8/17.
 */

public class LowestCommonAncestor {
    class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    @Test
    public void test() throws Exception {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(lca2(node1, 2, 7,true));
    }

    Node lca2(Node node, int index1, int index2, boolean root) {
        if (node == null) {
            return null;
        }

        Node left = lca2(node.left, index1, index2, false);
        Node right = lca2(node.right, index1, index2, false);

        if (left != null && right != null) {
            return node;
        }

        if (node.data == index1 || node.data == index2) {
            return node;
        }

        if(!root) {
            if (left != null) {
                return left;
            }

            if (right != null) {
                return right;
            }
        }

        return null;
    }

    Node lcs(Node node, int index1, int index2) {
        if (node == null) {
            return null;
        }
        System.out.println(node.toString());
        if (node.data == index1 || node.data == index2) {
            return node;
        }

        Node node1 = lcs(node.left, index1, index2);
        Node node2 = lcs(node.right, index1, index2);

        if (node1 != null && node2 != null) {
            return node;
        } else if (node1 != null) {
            return node1;
        } else if (node2 != null) {
            return node2;
        }


        return null;
    }
}
