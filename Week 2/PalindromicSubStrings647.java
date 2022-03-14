public class PalindromicSubStrings647 {
    public static int countSubstrings(String s){

        /*
        Method 1: O(n^2)
        Iterate through input twice. 
        First one checking for odd palindromes start l and r pointers at same point and grow them outwards
        updating count as you go. 
        Second pass start right pointer +1 from left and grow outwards. While updating count. 
        */ 
        int count = 0;  
        // odd palindrome pass
        for(int i = 0; i <s.length(); i++){
            int left = i, right = i;
            while((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))){ 
                count++; 
                left--;
                right++; 
            }
        }
        // even palindrom pass 
        for(int i = 0; i <s.length(); i++){
            int left =i, right = i+1;
            while((left >= 0 && right < s.length()) && (s.charAt(left) == s.charAt(right))) {    
                count++; 
                left--;
                right++; 
            }
        }
        return count; 
    }
    public static void main(String[] args) {
        String s = "fdsklf"; 
        System.out.println(countSubstrings(s));
    }
    
}
