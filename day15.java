import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class day15 {
    public int lengthOfLongestSubstring1(String s) {
        int left = 0, right = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;

        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c) && map.get(c) >= left) { // c is repeating char
                left = map.get(c) + 1;
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    
    public int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        int len = 0;

        for (right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            // now the string will valid
            len = Math.max(len, right - left + 1);
        }

        return len;
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the string: ");
        String input= sc.next();
        day15 obj= new day15();

        System.out.println("the length of the longest string without repeating char is : ");
        System.out.println("with approach 1: "+obj.lengthOfLongestSubstring1(input));
        System.out.println("with approach 2: "+obj.lengthOfLongestSubstring2(input));
        sc.close();
    }
    
}
