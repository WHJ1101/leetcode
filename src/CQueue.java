import java.util.Deque;
import java.util.LinkedList;

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<Integer>();
        stack2 = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        if(!stack2.isEmpty()){
            return stack2.pop();
        }
        return -1;
    }
}