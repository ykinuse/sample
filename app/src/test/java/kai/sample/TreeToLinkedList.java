package kai.sample;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by yongkai.teo on 21/8/17.
 */

public class TreeToLinkedList {
    class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
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

        LinkedList<Integer> list = new LinkedList<>();
        toLinkedList(node1, list);
        for (Integer i : list) {
            System.out.print(i);
        }
    }

    void toLinkedList(Node root, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }

        toLinkedList(root.left, list);
        list.add(root.data);
        toLinkedList(root.right, list);
    }

}
