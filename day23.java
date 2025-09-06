import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class day23 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int result[]= new int[n-k+1];   // n-k+1 = no. of subarrays with size k
        int resultIndex=0;

        Deque<Integer> q= new ArrayDeque<>();   // will store the indices

        for (int i=0; i<n; i++){        // i == right pointer
            
            // i) remove outof window indices
            if(!q.isEmpty() && q.peek()== i-k){
                q.poll();
            }

            //ii) removing elems which are <= the nums[i], because they no more matters
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();
            }

            q.offer(i);

            if(i >= k-1){
                result[resultIndex]= nums[q.peek()];  // storing the max no. from the window
                resultIndex++;
            }
        }

        return result;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the array size-");
        int n= sc.nextInt();
        int arr[]= new int[n];
        System.out.println("enter array elems-");
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        System.out.println("enter the value of k:");
        int k= sc.nextInt();

        int maxValues[]= maxSlidingWindow(arr, k);

        for(int maxValue : maxValues){
            System.out.print(maxValue+" ");
        }
        sc.close();
    }
}
