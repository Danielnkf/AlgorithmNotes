/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 */
//more staightforward
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0;i<s.length();i++){
            if( s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')
                stack.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(stack.isEmpty() || stack.pop()!='(')
                    return false;
            }
            else if(s.charAt(i)==']'){
                if(stack.isEmpty() || stack.pop()!='[')
                    return false;
            }
            else if(s.charAt(i)=='}'){
                if(stack.isEmpty() || stack.pop()!='{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
 
 
public class ValidParentheses {
/*    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if(stack.isEmpty())
                return false;
            else {
                char pop = stack.pop();
                if(pop == '(' && s.charAt(i) != ')' || pop == '[' && s.charAt(i) != ']'
                        || pop == '{' && s.charAt(i) != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }
*/


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else if(stack.isEmpty() || s.charAt(i) - stack.pop() > 2)
                return false;
        }
        return stack.isEmpty();
    }
}
