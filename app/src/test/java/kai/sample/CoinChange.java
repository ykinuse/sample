package kai.sample;

import org.junit.Test;

/**
 * Created by ykinuse on 16/8/17.
 */

public class CoinChange {
    @Test
    public void test() {
        int[] coins = new int[]{1, 5, 10, 25};

        int[] cache = new int[40];
        for (int i = 0; i < cache.length; i++) {
            cache[i] = -1;
        }
        System.out.println(change(40, coins, cache));
    }

    public int change(int input, int[] coins, int[] cache) {
        if (input == 0) {
            return 0;
        }

        int min = input;
        for (int coin : coins) {
            if (input - coin >= 0) {
                int changes;
                if (cache[input - coin] >= 0) {
                    changes = cache[input - coin];
                } else {
                    changes = change(input - coin, coins, cache);
                    cache[input - coin] = changes;
                }

                min = Math.min(min, changes + 1);
            }
        }

        return min;
    }
}
