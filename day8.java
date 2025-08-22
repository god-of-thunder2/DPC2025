// reverse the sentence word by wo

import java.util.Scanner;

public class day8 {

    // approach 1
    public static String reverse1(String s){
        String[] words= s.trim().split("\\s+");
        // here we are removing spaces at the ends of string
        // and converting that string into array "words" by seperator
        // as one or more spaces, tab or newline

        StringBuilder sb= new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            sb.append(words[i]);

            if(i>0) sb.append(" ");
        }

        return sb.toString();
    }

    // approach 2
    public static String reverse2(String s){
        StringBuilder sb=  new StringBuilder();


        int i= s.length()-1;
        while(i>=0){
            while(i>=0 && s.charAt(i)==' ') i--;

            if(i<0) break;

            int j=i;
            while(i>=0 && s.charAt(i)!=' ') i--;
            
            if(sb.length()>0) sb.append(" ");
            sb.append(s.substring(i+1, j+1));
        }

        return sb.toString();
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the sentence");
        String sentence= sc.nextLine();
        System.out.println("with approach 1 = "+ reverse1(sentence));
        System.out.println("with approach 2 = "+ reverse2(sentence));
        sc.close();
    }
}
