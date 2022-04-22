import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s){


        int length = s.length();
        Stack<Character> stack = new Stack<>();
        char current;
        for(int i =0; i<length; i++){
            current = s.charAt(i);
            if(current =='{'||current =='('||current =='['){
                stack.push(current);
            }
            else{
                if(!stack.isEmpty()){
                    char pop = stack.pop();
                    if(!isSame(pop,current)){
                        return false;
                    }
                }
                else{
                    return false;
                }


            }
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }


    public static boolean isSame(char c, char a){
        switch(c){
            case '(':
                if(a == ')'){
                return true;
            }else {
                    return false;
                }
            case '{': if(a == '}'){
                return true;
            }else {
                return false;
            }
            case '[': if(a == ']'){
                return true;
            }else {
                return false;
            }
                default: return false;

        }
    }

    public static void main(String[] args) {
        String s = "[()([]{})]";
        System.out.println(isValid(s));

    }
}
