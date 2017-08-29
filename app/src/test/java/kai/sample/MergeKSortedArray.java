package kai.sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by yongkai.teo on 29/8/17.
 */

public class MergeKSortedArray {
    @Test
    public void test() throws Exception {
        System.out.println(Arrays.toString(mergeKSortedArray2(new int[][]{new int[]{2, 5, 8}, new int[]{1, 4, 7}, new int[]{3, 6, 9}})));
    }

    private Integer[] mergeKSortedArray(int[][] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] arr2 : arr) {
            for (int i : arr2) {
                set.add(i);
            }
        }

        return new ArrayList<>(set).toArray(new Integer[set.size()]);
    }

    private int[] mergeKSortedArray2(int[][] arr) {
        PriorityQueue<NodeQueue> nodeQueues = new PriorityQueue<>();
        int size = 0;
        for (int[] i : arr) {
            size += i.length;
            nodeQueues.add(new NodeQueue(i, 0, i[0]));
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            NodeQueue nodeQueue = nodeQueues.poll();
            result[i] = nodeQueue.value;
            if (nodeQueue.index + 1 < nodeQueue.arr.length) {
                nodeQueues.add(new NodeQueue(nodeQueue.arr, nodeQueue.index + 1, nodeQueue.arr[nodeQueue.index + 1]));
            }

        }

        return result;
    }

    class NodeQueue implements Comparable<NodeQueue> {
        int[] arr;
        int index;
        int value;

        public NodeQueue(int[] arr, int index, int value) {
            this.arr = arr;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(NodeQueue nodeQueue) {
            if (nodeQueue.value > value) {
                return -1;
            }
            if (nodeQueue.value < value) {
                return 1;
            }

            return 0;
        }
    }
}
