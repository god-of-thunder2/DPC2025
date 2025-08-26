// same like leetcode 47

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class day11 {

    static void permute(String s, String ans, Set<String> result) {
        if (s.length() == 0) {
            result.add(ans); // avoiding duplicates by adding to set
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            permute(ros, ans + ch, result);
        }
    }

    public static List<String> getPermutations(String s) {
        Set<String> resultSet = new HashSet<>();
        permute(s, "", resultSet);
        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string (word)");
        String s = sc.next();
        List<String> permutations = getPermutations(s);
        System.out.println(permutations);
        sc.close();
    }
}
