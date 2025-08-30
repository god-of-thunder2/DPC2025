import java.util.Scanner;

public class day16 {

    public int lcm(int a, int b){
        int max= Math.max(a, b);
        for(int i= max; i<= (a*b); i++){
            if(i%a==0 && i%b==0) return i;
        }

        return a*b;
    }

    // optimal approach
    public int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b= a%b;
            a= temp;
        }

        return a;
    }

    public int LCM(int a, int b){
        return (a*b)/(gcd(a, b));
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter n: ");
        int n= sc.nextInt();

        System.out.println("enter m: ");
        int m= sc.nextInt();

        day16 obj= new day16();

        System.out.println("the lcm is : "+ obj.lcm(n, m));
        System.out.println("the lcm is : (with optimal approach)"+ obj.LCM(n, m));
        sc.close();
    }
}
