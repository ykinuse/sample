package kai.sample;

import org.junit.Test;

import java.util.Map;

/**
 * Created by yongkai.teo on 16/8/17.
 */

public class RandomNode {
    class Node {
        Node next;
        Node random;
        int data;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return super.toString() + " Node{" +
                    "data=" + data +
                    ", random=" + (random == null ? "null" : "" + random.data) +
                    '}';
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

        node1.random = node3;
        node2.random = node1;
        node3.random = node3;
        node4.random = node2;

//        Node nextNode = duplicate(node1, new HashMap<Integer, Node>());
        duplicateNext(node1);
        Node nextNode = node1;
        while (nextNode != null) {
            System.out.println(nextNode.toString());
            nextNode = nextNode.next;
        }
        System.out.println("====");
        duplicateRandom(node1);

        nextNode = abstractDuplicate(node1);
        while (nextNode != null) {
            System.out.println(nextNode.toString());
            nextNode = nextNode.next;
        }
    }

    public void duplicateNext(Node node) {
        if (node == null) {
            return;
        }

        Node nextNode = node.next;
        node.next = new Node(node.data);
        node.next.next = nextNode;
        duplicateNext(node.next.next);
    }

    public void duplicateRandom(Node node) {
        if (node == null || node.next == null) {
            return;
        }

        if (node.next.data == node.data) {
            node.next.random = node.random == null ? null : node.random.next;
        }

        duplicateRandom(node.next.next);
    }

    public Node abstractDuplicate(Node node) {
        if (node == null) {
            return null;
        }

        Node newNode = node.next;
        node.next = newNode.next;

        newNode.next = abstractDuplicate(node.next);
        return newNode;
    }

    public Node duplicate(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }

        Node dupNode;
        if (map.containsKey(node.data)) {
            dupNode = map.get(node.data);
        } else {
            dupNode = new Node(node.data);
            map.put(node.data, dupNode);
        }

        if (node.random != null) {
            if (map.containsKey(node.random.data)) {
                dupNode.random = map.get(node.random.data);
            } else {
                dupNode.random = new Node(node.random.data);
                map.put(node.random.data, dupNode.random);
            }
        }

        dupNode.next = duplicate(node.next, map);
        return dupNode;
    }
}
