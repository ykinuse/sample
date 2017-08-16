package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 8/8/17.
 */

public class LongestCommonSubSeq {
    @Test
    public void test() {
        System.out.println(longestCommonSubseq("abcdaf", "acbcf"));
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
                text += text2.charAt(text2Index - 1);
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
