// floyd's hare and tortoise

import java.util.Scanner;

public class day3 {
    public static int findDuplicate(int[] nums) {
        // here we are treating arr as linked list, as the elem at index is the index to next node
        int slow=nums[0];
        int fast=nums[0];

        do{
            slow= nums[slow];   // moves 1 step
            fast= nums[nums[fast]];     // moves 2 steps
        } while(slow!=fast);

        // both have meet, now restart fast to start
        fast= nums[0];
        while(fast != slow){
            fast= nums[fast];
            slow= nums[slow];
        }

        // when they meet is the duplicate no. is found
        return slow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter size of array-");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.println("enter elems:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Duplicate elem. is- "+findDuplicate(arr));

        sc.close();
    }
}
