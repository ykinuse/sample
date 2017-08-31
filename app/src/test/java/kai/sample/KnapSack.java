package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 30/8/17.
 */

public class KnapSack {
    int count = 0;

    @Test
    public void test() throws Exception {
        int weight = 5;
        int[][] arr = new int[][]{new int[]{1, 5}, new int[]{2, 3}, new int[]{4, 5}, new int[]{2, 3}, new int[]{5, 2}};
        int[][] cache = new int[weight + 1][arr.length];
        for (int i = 0; i < weight + 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                cache[i][j] = -1;
            }
        }
//        System.out.println(maxValue(arr, weight, arr.length - 1));
        System.out.println(maxValueDP(arr, cache, weight, arr.length - 1));
        System.out.println("Total recurr " + count);
    }

    int maxValue(int[][] arr, int weight, int currentIndex) {
        count++;
        if (weight <= 0 || currentIndex < 0) {
            return 0;
        }

        if (weight < arr[currentIndex][0]) {
            return maxValue(arr, weight, currentIndex - 1);
        }

        int temp1 = maxValue(arr, weight, currentIndex - 1); // Not selecting current
        int temp2 = arr[currentIndex][1] + maxValue(arr, weight - arr[currentIndex][0], currentIndex - 1); // If select

        int result = Math.max(temp1, temp2);
        return result;
    }


    int maxValueDP(int[][] arr, int[][] cache, int weight, int currentIndex) {
        count++;
        if (weight <= 0 || currentIndex < 0) {
            return 0;
        }

        if (weight < arr[currentIndex][0]) {
            return maxValueDP(arr, cache, weight, currentIndex - 1);
        }

        if (cache[weight][currentIndex] != -1) {
            System.out.println("Get cache for " + weight + " " + currentIndex);
            return cache[weight][currentIndex];
        }

        int temp1 = maxValueDP(arr, cache, weight, currentIndex - 1); // Not selecting current
        int temp2 = arr[currentIndex][1] + maxValueDP(arr, cache, weight - arr[currentIndex][0], currentIndex - 1); // If select

        int result = Math.max(temp1, temp2);
        cache[weight][currentIndex] = result;
        return result;
    }
}
