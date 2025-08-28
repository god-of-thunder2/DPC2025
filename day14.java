// sliding window + hashing problem
// converting the problem helper(),find the no. of subarrays which contains <= different chars
import java.util.HashMap;
import java.util.Scanner;


class day14 {

    public int helper(String s, int k) {
        HashMap<Character, Integer> map= new HashMap<>();

        int left=0, right=0;
        int count=0;

        for(right=0; right<s.length(); right++){
            char c= s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);

            // if window violates the condition make it valid
            while(map.size() > k){
                char leftChar= s.charAt(left);
                map.put(leftChar, map.getOrDefault(leftChar,0)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }

            count=count + (right-left+1);   // right-left+1 == windows length means each index gives all possible arrays
        }

        return count;
    }

    public int subarraysWithKDistinct(String s, int k) {
        return helper(s, k) - helper(s, k-1);
    }

    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the string: ");
        String input= sc.next();
        System.out.println("enter k: ");
        int k= sc.nextInt();
        day14 obj= new day14();
        System.out.println("the no. of strings with exact k different chars is: "+ obj.subarraysWithKDistinct(input, k));
        sc.close();
    }
}