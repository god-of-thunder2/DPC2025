// find all leader elems. leader elem- all to its right are smaller

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day5{

    public static List<Integer> findLeader(int nums[]){
        int n= nums.length;
        List<Integer> result= new ArrayList<>();
        int leader = nums[n-1];     // last elem is always a leader
        result.add(leader);

        for( int i=n-2; i>=0; i--){         // traversing right to left
            if(nums[i]>leader){
                result.add(nums[i]);
                leader= nums[i];
            }
        }

        Collections.reverse(result);

        return result;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the array size-");
        int n= sc.nextInt();
        int arr[]= new int[n];
        System.out.println("enter array elems-");
        for(int i=0; i<n ;i++){
            arr[i]= sc.nextInt();
        }
        List<Integer> list=findLeader(arr);
        for(int num: list){
            System.out.print(num+ " ");
        }
        sc.close();
    }
}