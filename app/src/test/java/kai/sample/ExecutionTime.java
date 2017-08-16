package kai.sample;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by yongkai.teo on 10/8/17.
 */

public class ExecutionTime {
    @Test
    public void test() {
        System.out.println(rearrange(new char[]{'a', 'a', 'a', 'b', 'b', 'c', 'c'}, 3));
    }

    public int totalExecuteTime(char[] arrays, int k) {
        int total = 1;
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] == arrays[i - 1]) {
                total += k + 1;
            } else {
                total += 1;
            }
        }

        return total;
    }

    public String rearrange(char[] arrays, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arrays) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        String text = "";
        Character current = null;
        while (true) {
            System.out.println(map.toString());
            Character cached = null;
            int count = 0;
            for (char c : map.keySet()) {
                if (map.get(c) > count && (current == null || c != current)) {
                    System.out.println("Swap " + current + " " + c);
                    cached = c;
                    count = map.get(c);
                }
            }

            if (cached == null) {
                break;
            }
            current = cached;

            text += current;
            map.put(current, count - 1);

        }
        return text;
    }
}
