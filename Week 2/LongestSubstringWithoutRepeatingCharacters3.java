import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public static int lengthofLongestSubstring(String s){
        Set<Character> bucket = new HashSet<>(); 
        int maxSub = 0; 
        int left = 0; 
        for(int right = 0; right < s.length(); right++){
            while(bucket.contains(s.charAt(right))){
                bucket.remove(s.charAt(left)); 
                left++; 
            }
            bucket.add(s.charAt(right)); 
            maxSub = Math.max(maxSub, bucket.size()); 
        }


        return maxSub; 
    }

  ; 

    
    public static void main(String[] args) {
        String input = "abcabcbdew"; 
        System.out.println(lengthofLongestSubstring(input));
    }
    
}
