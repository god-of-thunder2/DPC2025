import java.util.Scanner;

public class day13 {
    public String expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }

        return s.substring(left+1, right);
    }

    public String longestPalindrome(String s) {

        String longest= "";

        for(int i=0; i<s.length(); i++){
            // odd length palindrome
            String p1= expandAroundCenter(s, i, i);
            if(p1.length() > longest.length()){
                longest = p1;
            }

            // even length palindrome
            String p2= expandAroundCenter(s, i, i+1);
            if(p2.length() > longest.length()){
                longest = p2;
            }
        }

        return longest;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the string:");
        String input= sc.next();
        day13 obj = new day13();
        System.out.println("longest palindrome string is: " + obj.longestPalindrome(input));
        sc.close();
    }
}
