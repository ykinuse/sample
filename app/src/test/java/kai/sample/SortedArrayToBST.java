package kai.sample;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Created by yongkai.teo on 24/8/17.
 */

public class SortedArrayToBST {
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

    Node list = new Node(1);

    @Test
    public void test() throws Exception {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node node = toBst(arr, 0, arr.length - 1);

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        list.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;

        Node nodee = toBst(5);


//        inorder(node);
//        inorder(nodee);
        LinkedList<Integer> a = new LinkedList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        inorder(toBst(5, a));
    }

    private Node toBst(int n, LinkedList<Integer> linkedList) {
        if (n <= 0) {
            return null;
        }

        Node left = toBst(n / 2, linkedList);
        Node root = new Node(linkedList.pop());
        root.left = left;
        root.right = toBst(n - (n / 2) - 1, linkedList); // Exclude current middle node
        return root;
    }

    private Node toBst(int n) {
        if (n <= 0) {
            return null;
        }

        Node left = toBst(n / 2);
        Node root = new Node(list.data);
        root.left = left;
        list = list.left;
        root.right = toBst(n - (n / 2) - 1); // Exclude current middle node
        return root;
    }

    private Node toBst(int[] sortedArray, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(sortedArray[mid]);
        root.left = toBst(sortedArray, start, mid - 1); // 4 << 1 << 0
        root.right = toBst(sortedArray, mid + 1, end); // <<
        return root;
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }
}
