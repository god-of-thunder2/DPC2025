// return the list of prime factors of n and if n is prime then list only contains n

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class day17 {

    // optimal approach only checking upto sqrt(n)

    public List<Integer> primeFactors1(int n){
        List<Integer> list= new ArrayList<>();
        if(n<=1) return list;   // 1 is not prime, and prime factorization is not for -ve 

        // divide by even factor (2)
        while(n%2==0){
            list.add(2);
            n/=2;
        }

        // now divide by odd factors, n is no more divisible by evens
        for(int i=3; i*i<=n; i+=2){     // we are considering only factors <= sqrt(n)
            while(n%i==0){
            list.add(i);
            n/=i;
            }
        }

        // if n is still > 1 it is prime leftover
        if(n>1) list.add(n);

        return list;
    }

    // brute force
    public List<Integer> primeFactors2(int n){
        List<Integer> list= new ArrayList<>();
        int d=2;

        while(n>1){
            if(n%d==0){
                list.add(d);
                n/=d;
            }
            else{
                d++;
            }
        }

        return list;
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter n: ");
        int n= sc.nextInt();

        System.out.println("the prime factors of "+n+" are: ");
        day17 obj= new day17();
        List<Integer> list= obj.primeFactors1(n);
        System.out.println(list);

        System.out.println(" with brute force-");
        list= obj.primeFactors2(n);
        System.out.println(list);
        sc.close();
    }
}
