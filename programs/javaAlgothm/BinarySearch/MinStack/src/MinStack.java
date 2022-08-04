import java.util.Stack;

public class MinStack {
    //辅助栈
    Stack<Integer> dataStack;
    Stack<Integer> minStack;
    public MinStack() {

        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(dataStack.isEmpty()){
            dataStack.push(val);
            minStack.push(val);

        }
        else {
            dataStack.push(val);
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();

    }

    public int getMin() {
        return minStack.peek();

    }

}
