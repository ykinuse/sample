package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 10/8/17.
 */

public class PostorderTraversal {
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return data == node.data;

        }

        @Override
        public int hashCode() {
            return data;
        }
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node1.right = node3;
        node3.right = node7;
        node7.right = node8;
        postorderTraversal(node1);
    }

    public Node postorderTraversal(Node root) {
        if (root == null) {
            return null;
        }

        postorderTraversal(root.left);
        postorderTraversal(root.right);

        System.out.println(root.data);
        return root;
    }
}
