// rain trapping problem

import java.util.Scanner;

public class day7 {

    public int[] getLeftMaxArray(int height[]){
        int n= height.length;
        int arr[]= new int[n];
        arr[0]=height[0];

        int max=arr[0];
        for(int i=1; i<n; i++){
            if(height[i] > max){
                arr[i]= height[i];
                max= height[i];
            } else{
                arr[i]= max;
            }
        }

        return arr;
    }

     public int[] getRightMaxArray(int height[]){
        int n= height.length;
        int arr[]= new int[n];
        arr[n-1]=height[n-1];

        int max=arr[n-1];
        for(int i=n-2; i>=0; i--){
            if(height[i] > max){
                arr[i]= height[i];
                max= height[i];
            } else{
                arr[i]= max;
            }
        }

        return arr;
    }

    public int trap(int[] height) {
        int n= height.length;
        int water=0;

        int leftMax[] =getLeftMaxArray(height);
        int rightMax[]=getRightMaxArray(height);

        for(int i=0; i<n;i++){
            water+= Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
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

        day7 obj= new day7();
        System.out.println("Water being trapped is ="+ obj.trap(arr));
        sc.close();
    }
}