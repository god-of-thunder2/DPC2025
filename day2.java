import java.util.Scanner;

public class day2 {

    public static int missingNo(int arr[]){
        int n= arr.length+1;
        int total= n*(n+1)/2;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
        }
        return total-sum;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size of array:");
        int n= sc.nextInt();
        int arr[]= new int[n];
        System.out.println("fill the elems(1 to n+1, one will missing)");
        for( int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }

        System.out.println(missingNo(arr));
        sc.close();
    }
}
