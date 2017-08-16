package kai.sample;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by yongkai.teo on 10/8/17.
 */

public class StringPremutation {
    @Test
    public void test() {
        premutation("aabc".toCharArray());
    }

    public void premutation(char[] chars) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        premuate(map, "", chars.length);
    }

    public void premuate(HashMap<Character, Integer> map, String acc, int length) {
        if (acc.length() == length) {
            System.out.println(acc);
            return;
        }

        for (Character character : map.keySet()) {
            if (map.get(character) > 0) {
                map.put(character, map.get(character) - 1);
                premuate(map, acc + character, length);
                map.put(character, map.get(character) + 1);
            }
        }
    }
}
