import java.util.Stack;

public class LeetCode155MinStack {
    private Stack<Integer>dataStack;
    private Stack<Integer>minStack;


    public LeetCode155MinStack() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        int x = dataStack.pop();
        if(x == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        LeetCode155MinStack text = new LeetCode155MinStack();
        text.push(-2);
        text.push(0);
        text.push(-3);
        System.out.println(text.getMin());
        System.out.println(text.getMin());
        System.out.println(text.top());
        text.pop();
        System.out.println(text.top());
        System.out.println(text.getMin());


    }
}
