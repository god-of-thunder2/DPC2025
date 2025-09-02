import java.util.Scanner;
import java.util.Stack;

public class day19 {

    public static int postfix(String exp){
        String tokens[]= exp.trim().split("\\s+");
        Stack<Integer> stack= new Stack<>();

        for(String token : tokens){
            // if the token is number push into stack if it is operator pop two operands and push their result into stackk
            if(token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")){
                    int b= stack.pop();     // right operand
                    int a= stack.pop();     // left operand

                    switch(token){
                        case "+": stack.push(a+b); break;
                        case "-": stack.push(a-b); break;
                        case "*": stack.push(a*b); break;
                        case "/": stack.push(a/b); break;
                    }
            } else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop(); // remaining no. is the answer
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter only valid expression string:");
        String exp= sc.nextLine();
        System.out.println("the result is :"+postfix(exp)); 
        sc.close();
    }
}
