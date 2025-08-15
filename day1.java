import java.util.Scanner;

public class day1 {

    public static void rearrangeArray(int arr[]){
        int n= arr.length;
        int i=0;
        int start=0;
        int end=n-1;
        while(i<=end){
            if(arr[i]==0){
                //swap with the start and move start ahead
                int temp= arr[start];
                arr[start]= arr[i];
                arr[i]= temp;
                start++;
                i++;
            }
            else if(arr[i]==2){
                // swap with end and move end to left
                int temp= arr[end];
                arr[end]= arr[i];
                arr[i]= temp;
                end--;
                // remember: don't do i++
            }
            else{
                // elem is 1
                i++;
            }
        }
    }
    public static void main(String []args){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n= sc.nextInt();
        int arr[]= new int[n];
        System.out.println("fill the elems(0, 1, 2)");
        for( int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        rearrangeArray(arr);
        //printing the array
        for(int i=0; i< arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        sc.close();
    }
}
