package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 8/8/17.
 */

public class LongestCommonSubSeq {
    static int count = 0;

    @Test
    public void test() {
        System.out.println(longestCommonSubseq("abcdaf", "acbcf"));
//        System.out.println(lcss("abcdaf", "acbcf", "abcdaf".length() - 1, "acbcf".length() - 1));
        int[][] cache = new int["abcdaf".length()]["acbcf".length()];
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[i].length; j++) {
                cache[i][j] = -1;
            }
        }
        System.out.println(lcssDP("abcdaf", "acbcf", "abcdaf".length() - 1, "acbcf".length() - 1, cache));
        System.out.println("Total reccur " + count);
    }

    public static int lcssDP(String text1, String text2, int index1, int index2, int[][] cache) {
        count++;
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (cache[index1][index2] != -1) {
            return cache[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            int result = 1 + lcssDP(text1, text2, index1 - 1, index2 - 1, cache);
            cache[index1][index2] = result;
            return result;
        }

        int result = Math.max(lcssDP(text1, text2, index1 - 1, index2, cache), lcssDP(text1, text2, index1, index2 - 1, cache));
        cache[index1][index2] = result;
        return result;
    }


    public static int lcss(String text1, String text2, int index1, int index2) {
        count++;
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            return 1 + lcss(text1, text2, index1 - 1, index2 - 1);
        }

        return Math.max(lcss(text1, text2, index1 - 1, index2), lcss(text1, text2, index1, index2 - 1));
    }

    public static int longestCommonSubseq(String text1, String text2) {
        int text1Size = text1.length();
        int text2Size = text2.length();
        int[][] result = new int[text1Size + 1][text2Size + 1];
        for (int i = 0; i <= text2Size; i++) {
            for (int j = 0; j <= text1Size; j++) {
                if (i == 0 || j == 0) {
                    result[j][i] = 0;
                } else if (text2.charAt(i - 1) == text1.charAt(j - 1)) {
                    result[j][i] = 1 + result[j - 1][i - 1];
                } else {
                    result[j][i] = Math.max(result[j][i - 1], result[j - 1][i]);
                }
            }
        }

        String text = "";
        int text1Index = text1Size;
        int text2Index = text2Size;
        while (text1Index > 0 && text2Index > 0) {
            int value = result[text1Index][text2Index];
            if (value != result[text1Index - 1][text2Index] && value != result[text1Index][text2Index - 1]) {
                text = text2.charAt(text2Index - 1) + text;
                text1Index--;
                text2Index--;
            } else if (value == result[text1Index - 1][text2Index]) {
                text1Index--;
            } else {
                text2Index--;
            }
        }
        System.out.println(text);


        return result[text1Size][text2Size];
    }
}
