package kai.sample;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by yongkai.teo on 11/8/17.
 */

public class PossibleCombination {
    HashMap<String, String> map = new HashMap<>();

    @Test
    public void test() {
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        map.put("14", "n");
        map.put("15", "o");
        map.put("16", "p");
        map.put("17", "q");
        map.put("18", "r");
        map.put("19", "s");
        map.put("20", "t");
        map.put("21", "u");
        map.put("22", "v");
        map.put("23", "w");
        map.put("24", "x");
        map.put("25", "y");
        map.put("26", "z");

        checkPossible("11234", "");
    }

    public void checkPossible(String text, String acc) {
        String current = "" + text.charAt(0);
        if (text.length() > 1) {
            for (int i = 1; i < text.length(); i++) {
                if (map.containsKey(current)) {
                    checkPossible(text.substring(i, text.length()), acc + map.get(current));
                }
                current = text.substring(0, i + 1);
            }
        }

        if (map.containsKey(current)) {
            System.out.println(acc + map.get(current));
        }

    }
}
