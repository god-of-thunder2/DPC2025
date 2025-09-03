import java.util.Scanner;
import java.util.Stack;

public class day20 {
    public static void sortStack(Stack<Integer> stack){
        // base condition
        if(stack.isEmpty()){
            return;
        }

        int top= stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }

    public static void insertSorted(Stack<Integer> stack, int value){
        // base condition
        if(stack.isEmpty() || value >= stack.peek()){
            // push directly
            stack.push(value);
            return;
        }

        int top= stack.pop();
        insertSorted(stack, value);
        stack.push(top);
    }

    public static void main(String[] args) {
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
        sortStack(stack);
        System.out.println(" sorted stack: " + stack);

        sc.close();
    }
}
