package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 10/8/17.
 */

public class BinaryDepth {
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
        node1.left = node2;
        node2.left = node4;
        node4.right = node5;
        node1.right = node3;
        System.out.println(maxDepth(node1, 0));
    }

    int maxDepth(Node node, int index) {
        if (node == null) {
            return 0;
        }

        return index + Math.max(maxDepth(node.left, 1), maxDepth(node.right, 1));
    }
}
