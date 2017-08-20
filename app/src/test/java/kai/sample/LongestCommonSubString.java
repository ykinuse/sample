package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 20/8/17.
 */

public class LongestCommonSubString {
    @Test
    public void test() {
        longestCommonSubString("ABAB", "BABA");
        longestCommonSubString("abcdaf", "acbcf");
    }

    public static void longestCommonSubString(String text1, String text2) {
        String out = "";
        int text1Size = text1.length();
        int text2Size = text2.length();
        int[][] result = new int[text1Size][text2Size];
        for (int i = 0; i < text1Size; i++) {
            for (int j = 0; j < text2Size; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 1 + result[i - 1][j - 1];
                    }
                } else {
                    result[i][j] = 0;
                }

                if (result[i][j] > out.length()) {
                    out = text1.substring(i - result[i][j] + 1, i + 1);
                }
            }
        }

        System.out.println(out);
    }
}
