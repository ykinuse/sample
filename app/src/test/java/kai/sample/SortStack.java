package kai.sample;

import org.junit.Test;

import java.util.Stack;

/**
 * Created by ykinuse on 20/8/17.
 */

public class SortStack {
    @Test
    public void test() throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.add(4);
        stack.add(2);
        stack.add(3);
        stack.add(1);

        Stack<Integer> sortedStack = new Stack<>();
        sortedStack.push(stack.pop());
        Integer curr;
        while (!stack.isEmpty()) {
            curr = stack.pop();
            while (!sortedStack.isEmpty() && sortedStack.peek() < curr) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(curr);
        }

        while (!sortedStack.isEmpty()) {
            System.out.println(sortedStack.pop());
        }
    }
}
