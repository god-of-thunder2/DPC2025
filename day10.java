import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class day10 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        // using sorting approach
        HashMap<String, List<String>> map= new HashMap<>();

        for(String s:strs){
            // SORT the string
            char arr[]= s.toCharArray();
            Arrays.sort(arr);
            String key= new String(arr);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
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

        List<List<String>> result=groupAnagrams(arr);
        System.out.println(result);
        sc.close();
    }
}
