// reverse stack using recursion

import java.util.Scanner;
import java.util.Stack;

public class day21 {

    public static void reverseStack(Stack<Integer> stack){
        // base condition 
        if(stack.isEmpty()) return;

        int top= stack.pop();
        reverseStack(stack);
        // after the leftover stack is reversed push the current elem at bottom
        insertAtBottom(stack, top);
    }

    public static void insertAtBottom(Stack<Integer> stack, int value){
        if(stack.isEmpty()){
            stack.push(value);
            return;
        }

        int top= stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.print("enter the no. of elems-");
        int n = sc.nextInt();

        System.out.println("enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            stack.push(x);  
        }

        System.out.println(" initial stack: " + stack);
        reverseStack(stack);
        System.out.println(" reversed stack: " + stack);

        sc.close();
    }
}
