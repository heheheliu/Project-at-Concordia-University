import java.util.Stack;

public class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void push(int x) {
        if(s1.isEmpty()){
            front = x;
        }
        s1.push(x);

    }

    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
//        while(!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
        }
        return s2.pop();

    }

    public int peek() {
//        while(!s1.isEmpty()){
//            s2.push(s1.pop());
//        }
//        int front = s2.peek();
//        while(!s2.isEmpty()){
//            s1.push(s2.pop());
//        }
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return front;

    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();

    }
}
