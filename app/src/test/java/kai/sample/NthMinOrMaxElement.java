package kai.sample;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by ykinuse on 26/8/17.
 */

public class NthMinOrMaxElement {

    @Test
    public void test() throws Exception {
        System.out.println(maxNthElementPriorityQueue(new int[]{1, 5, 9, 2, 3, 8, 0, 2, 1, 10, -1, 9, 9, 6, 7}, 3));
        System.out.println(maxNthElement(new int[]{1, 5, 9, 2, 3, 8, 0, 2, 1, 10, -1, 9, 9, 6, 7}, 3));
        System.out.println(minNthElementPriorityQueue(new int[]{1, 5, 9, 2, 3, 8, 0, 2, 1, 10, -1, 9, 9, 6, 7}, 4));
        System.out.println(minNthElement(new int[]{1, 5, 9, 2, 3, 8, 0, 2, 1, 10, -1, 9, 9, 6, 7}, 4));
    }
    
    int maxNthElementPriorityQueue(int[] arr, int nth) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (Integer i : arr) {
            if (queue.size() != nth) {
                queue.add(i);
            } else {
                if (queue.contains(i)) {
                    continue;
                }

                if (queue.peek() < i) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }


        return queue.peek();
    }


    int minNthElementPriorityQueue(int[] arr, int nth) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(nth, Collections.reverseOrder());
        PriorityQueue<Integer> queue = new PriorityQueue<>(nth, new Comparator<Integer>() {
            @Override public int compare(Integer integer, Integer t1) {
                return t1.compareTo(integer);
            }
        });
        for (Integer i : arr) {
            if (queue.size() != nth) {
                queue.add(i);
            } else {
                if (queue.contains(i)) {
                    continue;
                }

                if (queue.peek() > i) {
                    queue.poll();
                    queue.add(i);
                }
            }
        }


        return queue.peek();
    }

    int maxNthElement(int[] arr, int nth) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer i : arr) {
            if (treeSet.size() != nth) {
                treeSet.add(i);
            } else {
                if (treeSet.contains(i)) {
                    continue;
                }

                if (treeSet.first() < i) {
                    treeSet.pollFirst();
                    treeSet.add(i);
                }
            }
        }


        return treeSet.first();
    }

    int minNthElement(int[] arr, int nth) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer i : arr) {
            if (treeSet.size() != nth) {
                treeSet.add(i);
            } else {
                if (treeSet.contains(i)) {
                    continue;
                }

                if (treeSet.last() > i) {
                    treeSet.pollLast();
                    treeSet.add(i);
                }
            }
        }


        return treeSet.last();
    }
}
