import java.util.Stack;

public class Solution {
    public static int evalRPN(String[] tokens) {

        Stack<Integer> operand = new Stack<>();
        for(int i = 0; i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int b = operand.pop();
                int a = operand.pop();
                int n = calculate(a,b,tokens[i]);
                operand.push(n);

            }
            else{
                operand.push(Integer.parseInt(tokens[i]));
            }
        }
        return operand.peek();

    }
    public static int calculate(int a, int b, String operator){
        switch (operator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
            default:
                return 0;
        }

    }

    public static void main(String[] args) {
        String[] list = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(list));
    }
}
