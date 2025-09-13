import java.util.Scanner;
import java.util.Arrays;

public class day30 {
    public static int minCoins(int coins[], int amount){
        int dp[]= new int[amount+1];
        Arrays.fill(dp, (amount+1));
        dp[0]=0;

        for(int i=1; i<= amount; i++){
            for(int coin: coins){
                if(i-coin >=0){
                    dp[i]= Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }

        return (dp[amount]>amount) ? -1 : dp[amount];
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the size of coins array-");
        int n= sc.nextInt();
        int coins[]= new int[n];

        System.out.println("enter the array elems-");
        for(int i=0; i<n; i++){
            coins[i]=sc.nextInt();
        }

        System.out.println("enter the amount:");
        int amount= sc.nextInt();
        System.out.println("minimum no. of coins need to make "+amount+"is: "+minCoins(coins, amount));
        sc.close();
    }
}
