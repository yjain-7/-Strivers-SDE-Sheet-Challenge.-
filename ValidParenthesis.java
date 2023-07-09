import java.util.*;
import java.util.Stack;
class ValidParenthesis{

    public static boolean isValidParenthesis(String expression) {
            int n = expression.length();
            Stack<Character> st = new Stack<>();
    
            for (int i = 0; i < n; i++) {
                if (st.isEmpty()) {
                    st.push(expression.charAt(i));
                } else if (st.peek() == '{' && expression.charAt(i) == '}') {
                    st.pop();
                } else if (st.peek() == '[' && expression.charAt(i) == ']') {
                    st.pop();
                } else if (st.peek() == '(' && expression.charAt(i) == ')') {
                    st.pop();
                } else {
                    st.push(expression.charAt(i));
                }
            }
    
            return st.isEmpty();
        }
}