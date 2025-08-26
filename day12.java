// valid parenthesis

import java.util.Scanner;
import java.util.Stack;

public class day12 {
    
    public static boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char top= stack.pop();
                if((c==')' && top != '(')
                    || (c=='}' && top!='{')
                    || (c==']' && top!='[')) return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the string having parenthesis chars: ()[]{} (any of these)");
        String input= sc.next();
        if(isValid(input)){
            System.out.println("String is valid");
        } else{
            System.out.println("String is not valid");
        }
        sc.close();
    }
}
