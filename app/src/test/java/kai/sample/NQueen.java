package kai.sample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yongkai.teo on 7/8/17.
 */

public class NQueen {
    class Interval {
        int x;
        int y;

        public Interval(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + y + "," + x + ")";
        }
    }

    @Test
    public void test() {
        final List<Interval> list = backtrack(5, 5, new ArrayList<Interval>(4));
        System.out.println(Arrays.toString(list.toArray(new Interval[list.size()])));
    }

    public List<Interval> backtrack(int row, int column, List<Interval> intervals) {
        for (int i = 0; i < row; i++) {
            Interval interval = new Interval(i, 0);
            intervals.add(interval);
            if (backtracking(row, column, intervals, 1)) {
                return intervals;
            } else {
                intervals.remove(interval);
            }
        }

        return intervals;
    }

    public boolean backtracking(int row, int column, List<Interval> intervals, int currentRow) {
        if (currentRow >= row) {
            return true;
        }

        for (int i = 0; i < column; i++) {
            boolean fit = true;
            for (Interval interval : intervals) {
                if (interval.x == i || interval.y == currentRow) {
                    fit = false;
                    break;
                }

                if (interval.y - interval.x == currentRow - i) {
                    fit = false;
                    break;
                }

                if (interval.y + interval.x == currentRow + i) {
                    fit = false;
                    break;
                }
            }

            if (!fit) {
                continue;
            }

            final Interval interval1 = new Interval(i, currentRow);
            intervals.add(interval1);
            final boolean success = backtracking(row, column, intervals, currentRow + 1);
            if (success) {
                return true;
            } else {
                intervals.remove(interval1);
            }
        }

        return false;
    }
}