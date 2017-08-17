package kai.sample;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by yongkai.teo on 17/8/17.
 */

public class PalindromeLinkedList {
    class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    @Test
    public void test() throws Exception {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(isPalindrome(node1));


        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(3);
        node5 = new Node(2);
        Node node6 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        System.out.println(isPalindrome(node1));
    }

    public boolean isPalindrome(Node node) {
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        Node runner = node;

        while (runner != null && runner.next != null) {
            stack.add(curr);
            curr = curr.next;
            runner = runner.next.next;
        }

        // Discard middle for even
        if (runner != null) curr = curr.next;

        while (!stack.isEmpty() && curr != null) {
            if (curr.data != stack.pop().data) {
                return false;
            }

            curr = curr.next;
        }

        return true;
    }
}
