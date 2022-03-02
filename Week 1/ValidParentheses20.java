import java.util.Stack;

public class ValidParentheses20 {

    /* 
    Brackets follow a FILO order so you can place the open
    brackets in a stack and whenever you come across a closed
    bracket pop() should return the corresponding bracket. 
    If these two do not match, return false; 
    The stack should be empty after it's run through the entire input. 
    */ 

    public static boolean isValid(String s){

        Stack<Character> stacky = new Stack<>();  
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stacky.push(s.charAt(i)); 
            else if(stacky.isEmpty())
                return false; 
            else if(s.charAt(i) == ')' && stacky.pop() != '(')
                    return false; 
            else if(s.charAt(i) == '}' && stacky.pop() != '{')
                    return false; 
            else if(s.charAt(i) == ']' && stacky.pop() != '[')
                    return false; 
        }
        return stacky.isEmpty(); 
    }
       
    public static void main(String[] args) {
        String s = "()[]{}"; 
        System.out.println(isValid(s));
    }
    
}
