package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 18/8/17.
 */

public class StringCompression {
    @Test
    public void test() throws Exception {
        System.out.println(compress("aaabccc"));
    }

    public String compress(String s) {
        if (s.length() == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        int count = 0;
        Character lastChar = null;
        for (char c : s.toCharArray()) {
            if (lastChar == null) {
                builder.append(c);
                lastChar = c;
                count++;
            } else if (c != lastChar) {
                builder.append(count);
                builder.append(c);
                lastChar = c;
                count = 1;
            } else {
                count++;
            }
        }

        builder.append(count);
        return builder.toString();
    }
}
