package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 4/8/17.
 */

public class ReverseLinkedList {
    class Node {
        int data;
        Node next;
        Node random;

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
                    ", random=" + random +
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

        Node reveresedNode = node4;
        while (reveresedNode.next != null) {
            reveresedNode = reveresedNode.next;
        }
        System.out.println(reveresedNode.toString());

        Node revNode = reveresedNode;
        Node node = node4;
        while (node.next != null) {
            System.out.println(node.next.toString());
            revNode.next = node.next;
            revNode = revNode.next;
            node = node.next;

        }


        System.out.println(reveresedNode.toString());
    }
}
