package stacksandqueue;

/*
    Goal of this class:
    This class calculates the stock span for each day based on daily stock
    prices. The span of a day indicates how many consecutive previous days,
    including the current day, had stock prices less than or equal to the
    current day's price. The solution uses a custom stack implemented with
    an array to efficiently track indices of days and compute spans.
*/

public class StockSpan {

    static int[] stack = new int[20];
    static int top = -1;

    // Pushes an index onto the stack
    static void push(int index) {
        stack[++top] = index;
    }

    // Pops and returns the top index from the stack
    static int pop() {
        return stack[top--];
    }

    // Checks whether the stack is empty
    static boolean isEmpty() {
        return top == -1;
    }

    // Returns the top index without removing it
    static int peek() {
        return stack[top];
    }

    // Calculates stock span values for each day
    static void calculateSpan(int[] prices, int[] span) {
        push(0);
        span[0] = 1;

        for (int i = 1; i < prices.length; i++) {
            while (!isEmpty() && prices[peek()] <= prices[i]) {
                pop();
            }
            span[i] = isEmpty() ? (i + 1) : (i - peek());
            push(i);
        }
    }

    // Entry point of the program
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = new int[prices.length];

        calculateSpan(prices, span);

        for (int i = 0; i < span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
