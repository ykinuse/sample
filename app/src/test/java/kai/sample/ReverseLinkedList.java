package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 4/8/17.
 */

public class ReverseLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }

        public String toRandomString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    @Test
    public void test() {
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;

        Node newList = null;
        Node curr = node4;
        Node nextNode;
        while (curr != null) {
            if (newList == null) {
                newList = curr;
                nextNode = curr.next;
                curr.next = null;
            } else {
                nextNode = curr.next;
                curr.next = newList;
                newList = curr;
            }

            curr = nextNode;
        }

        System.out.println(newList.toString());
    }

    @Test
    public void testDuplicatedONSpace() {
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;

        Node newList = null;
        Node curr = node4;
        while (curr != null) {
            if (newList == null) {
                newList = new Node(curr.data);
            } else {
                Node newNode = new Node(curr.data);
                newNode.next = newList;
                newList = newNode;
            }

            curr = curr.next;
        }

        System.out.println(newList.toString());
    }

    @Test
    public void testPrint() {
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        node4.next = node3;
        node3.next = node2;
        node2.next = node1;

        printNode(node4);
    }

    void printNode(Node node) {
        if (node == null) {
            return;
        }
        printNode(node.next);
        System.out.println(node.data);
    }
}
