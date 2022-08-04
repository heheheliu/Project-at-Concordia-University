import java.util.Stack;

public class minStackNode {
    Stack<Node> stack;
    public minStackNode() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new Node(val,val) );
        }else{
            stack.push(new Node(val, Math.min(val, stack.peek().min)));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
    private static class Node {
        int val;
        int min;
        public Node(int val, int min){
            this.min = min;
            this.val = val;
        }
    }
}
