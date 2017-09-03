package kai.sample;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by ykinuse on 3/9/17.
 */

public class TravelsalToNode {
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

        @Override public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }

        @Override
        public int hashCode() {
            return data;
        }
    }

    @Test
    public void test() throws Exception {
        int[] inorder = new int[]{4, 2, 6, 5, 1, 3, 7, 8};
        int[] postOrder = new int[]{4, 6, 5, 2, 8, 7, 3, 1};
        int[] preOrder = new int[]{1, 2, 4, 5, 6, 3, 7, 8};
        System.out.println(toBST(inorder, postOrder));
        System.out.println(toBSTFromPreOrder(inorder, preOrder));
    }

    Node toBST(int[] inorder, int[] postOrder) {
        if (inorder.length <= 0) {
            return null;
        }

        int value = postOrder[postOrder.length - 1];
        int index = 0;
        for (int i : inorder) {
            if (i == value) {
                break;
            }
            index++;
        }

        Node node = new Node(value);
        node.left = toBST(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(postOrder, 0, index));
        node.right = toBST(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(postOrder, index, postOrder.length - 1));
        return node;
    }

    Node toBSTFromPreOrder(int[] inorder, int[] preorder) {
        if (inorder.length <= 0) {
            return null;
        }

        int value = preorder[0];
        int index = 0;
        for (int i : inorder) {
            if (i == value) {
                break;
            }
            index++;
        }

        Node node = new Node(value);
        node.left = toBSTFromPreOrder(Arrays.copyOfRange(inorder, 0, index), Arrays.copyOfRange(preorder, 1, 1 + index + 1));
        node.right = toBSTFromPreOrder(Arrays.copyOfRange(inorder, index + 1, inorder.length), Arrays.copyOfRange(preorder, index + 1, preorder.length));
        return node;
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.println(root.data);
        inorderTraversal(root.right);
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.println(root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
}
