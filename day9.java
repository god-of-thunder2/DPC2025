// find longest common prefix from the array of stringss

import java.util.Arrays;
import java.util.Scanner;

public class day9{

    // approach 1:straightforward
    public static String findPref1(String s[]){

        if(s==null || s.length==0) return "";

        StringBuilder prefix= new StringBuilder();
        // find min. string length
        int len=Integer.MAX_VALUE;
        for(int i=0; i<s.length; i++){
            if(s[i].length()<len){
                len= s[i].length();
            }
        }

        for(int i=0; i<len; i++){
            char c= s[0].charAt(i);
            for(int j=1; j<s.length; j++){
                if(s[j].charAt(i)!=c){
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }

        return prefix.toString();
    }

    // approach 2: sorting technique

    public static String findPref2(String s[]){
        Arrays.sort(s);     // by sorting first and last string are most different than each other
        // so finding common prefix in them is applicable to in between also
        String start=s[0];
        String last=s[s.length-1];
        int i=0;

        int minLen= Math.min(start.length() , last.length());
        while(i<minLen && start.charAt(i)==last.charAt(i)){
            i++;
        }

        return start.substring(0, i);       // i is exclusive
    }


    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter array size-");
        int n= sc.nextInt();
        String arr[]= new String[n];
        System.out.println("enter array elems-");
        for(int i=0; i<n; i++){
            arr[i]= sc.next();
        }

        System.out.println("Longest common prefix is "+findPref1(arr));
        System.out.println("Longest common prefix is "+findPref2(arr));
        sc.close();
    }
}