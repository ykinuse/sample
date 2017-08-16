package kai.sample;

import org.junit.Test;

/**
 * Created by yongkai.teo on 14/8/17.
 */

public class Palindrome {
    @Test
    public void test() {
        System.out.println(longestPalindromeSubString("abaxabaxabb"));
    }

    public int longestPalindromeSubString(String text) {
        int max = 1;
        for (int i = 1; i < text.length(); i++) {

            int index = 1;
            int palindrome = 1;
            while (i - index >= 0 && i + index < text.length()) {
                if (text.charAt(i - index) == text.charAt(i + index)) {
                    palindrome = palindrome + 2;
                    index++;
                } else {
                    break;
                }
            }
            max = Math.max(max, palindrome);
        }

        return max;
    }

    public int longestPalindromeSubStringDP(String text) {
        int lastPalindromeIndex = 0;
        int[] cache = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            if (i == 0) {
                cache[i] = 1;
                continue;
            }

            if (lastPalindromeIndex >= 1) {
                int oppositeIndex = lastPalindromeIndex - (i - lastPalindromeIndex);
                if (oppositeIndex >= 0) {
                    int palindrome = cache[oppositeIndex];
                    if (palindrome == 1) {
                        cache[i] = palindrome;
                        continue;
                    } else if (oppositeIndex + cache[oppositeIndex] > lastPalindromeIndex + cache[palindrome] / 2) {
                        cache[i] = palindrome;
                        continue;
                    }
                }
            }

            int index = 1;
            int palindrome = 1;
            while (i - index >= 0 && i + index < text.length()) {
                if (text.charAt(i - index) == text.charAt(i + index)) {
                    palindrome = palindrome + 2;
                    index++;
                } else {
                    break;
                }
            }
            cache[i] = palindrome;
            lastPalindromeIndex = i;
        }

        int max = 0;
        for (int palindrome : cache) {
            max = Math.max(max, palindrome);
        }

        return max;
    }
}
