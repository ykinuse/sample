package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 21/8/17.
 */

public class LongestConsecutiveBranch {
    class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    @Test
    public void test() throws Exception {
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        Node node7 = new Node(3);
        Node node8 = new Node(4);
        Node node9 = new Node(5);
        Node node4_1 = new Node(2);
        Node node4_2 = new Node(3);
        Node node4_3 = new Node(4);
        Node node4_4 = new Node(5);
        Node node4_5 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
//        node7.right = node8;
//        node8.right = node9;
//        node4.right = node4_1;
//        node4_1.right = node4_2;
//        node4_2.right = node4_3;
//        node4_3.right = node4_4;
//        node4_4.right = node4_5;

        System.out.println(lcb(node1));

        // 0 >>    1 1
        // 1 >>    2 2 1's LEFT
        // 1 >>    2 2 1's LEFT
        // null >> 2 2 1's LEFT/RIGHT
        // 2 >>    3 3 1's RIGHT
        // 2 >>    1 1 ROOT RIGHT
        // 1 >>    1 1 2's LEFT
        // 3 >>    2 2 2's RIGHT
        // 4 >>    3 3 3's RIGHT
        // 5 >>    4 4 4's RIGHT << -- 4
    }

    int lcb(Node node) {
        return Math.max(lcb(node.left, node.data, 1), lcb(node.right, node.data, 1));
    }

    int lcb(Node node, int previousValue, int acc) {
        if (node == null) {
            return acc;
        }

        if (node.data == previousValue + 1) {
            acc = acc + 1;
        } else {
            acc = Math.max(1, acc - 1);
        }

        return Math.max(lcb(node.left, node.data, acc), lcb(node.right, node.data, acc));
    }
}
