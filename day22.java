// find the first elem that appears exactly k times

import java.util.Scanner;
import java.util.HashMap;

public class day22 {

    public static int find(int arr[], int k){
        HashMap<Integer, Integer> map= new HashMap<>();

        // create freq. map
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        // find first elem whose freq is k
        for(int num: arr){
            if(map.get(num)==k) return num;
        }

        return -1;      // no such elem
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n= sc.nextInt();

        int arr[]= new int[n];

        System.out.println("enter array elems:");
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        System.out.println("enter k:");
        int k= sc.nextInt();

        System.out.println("the first elem to appear "+k+" times is: "+ find(arr, k));
        sc.close();
    }
}
