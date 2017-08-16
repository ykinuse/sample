package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 16/8/17.
 */

public class NthElementLinkedList {
    class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(unOptimizedNth(3, node1).value);
        System.out.println(optimizedNth(3, node1).value);
    }


    public Node optimizedNth(int target, Node node) {
        Node currentNode = node;
        Node followerNode = node;
        int distance = 0;
        while (currentNode != null) {
            if (distance != target) {
                distance++;
            } else {
                followerNode = followerNode.next;
            }
            currentNode = currentNode.next;
        }

        return followerNode;
    }

    public Node unOptimizedNth(int target, Node node) {
        int length = 0;
        Node currentNode = node;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }

        currentNode = node;
        int element = length;
        while (element != target) {
            element--;
            currentNode = currentNode.next;
        }

        return currentNode;
    }
}
