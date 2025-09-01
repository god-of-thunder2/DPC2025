import java.util.Scanner;

public class day18 {

    public static int countDivisors(int n){
        int count=0;
        for(int i=1; i*i<=n; i++){      // go from 1 upto sqrt(n)
            if(n%i==0){
                count++;

                if(i != n/i){   // when n is perfect square ex. 36 then 6x6 pair should count once
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter n: ");
        int n= sc.nextInt();

        System.out.println("total divisors of n are: "+ countDivisors(n));
        sc.close();
    }
}
