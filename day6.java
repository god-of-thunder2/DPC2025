// return all subarrays whose sums up k, here k is 0

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class day6{

    public List<int[]> getSubarrays(int arr[], int k){
        HashMap<Integer, List<Integer>> map =new HashMap<>();
        List<int []> result= new ArrayList<>();
        int sum=0;

        for(int i=0; i<arr.length; i++){
            sum+=arr[i];    // current index's prefixSum
            if(sum==k){
                result.add(new int[]{0, i});
            }

            if(map.containsKey(sum-k)){
                for(int idx: map.get(sum-k)){
                    result.add(new int[]{idx+1, i});
                }
            }

            // put current sum in the map
            if(!map.containsKey(sum)){
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);
        }

        // return the result
        return result;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size for array-");
        int n= sc.nextInt();

        int arr[]= new int[n];
        System.out.println("enter array elems-");

        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        day6 obj= new day6();

        List<int[]> list =obj.getSubarrays(arr, 0);     // passing 0 as k

        System.out.println();
        if(!list.isEmpty()){
            int i=1;
            for(int nums[]:list){
            System.out.println((i++)+". (" +nums[0]+", "+nums[1]+" )");
            }
        } else{
            System.out.println("noo subarrays found..!");
        }
        sc.close();
    }
}