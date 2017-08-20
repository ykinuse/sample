package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 18/8/17.
 */

public class DivideLinkedList {
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override public String toString() {
            return "Node{" +
                    "next=" + next +
                    ", data=" + data +
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
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
        System.out.println(divide(node1));
        System.out.println(node1.toString());
    }

    Node divide(Node node) {
        Node runner = node.next;
        while (runner != null && runner.next != null) {
            node = node.next;
            runner = runner.next.next;
        }

        Node returnNode = node.next;
        node.next = null;
        return returnNode;
    }
}
