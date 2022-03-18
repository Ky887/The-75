
public class MinimumWindowSubstring76 {
    public static String minWindow(String s, String t){
        if(s.length() < t.length()){
            return ""; 
        }
       // s = s.toUpperCase(); 
       // t = t.toUpperCase(); 
        int left = 0, right = 0; 
        int match = 0; 
        int matchTarget = t.length();
        int minLen = Integer.MAX_VALUE;  
        String result = ""; 

        int[] current = new int[58]; 
        int[] want = new int[58]; 
        // Map<Character, Integer> current = new HashMap<>();  
       // Map<Character, Integer> want = new HashMap<>(); 

        // histogram for values that i want 
        for(int i = 0; i< t.length(); i++){
            want[t.charAt(i)-'A']++; 
        }
        for(right = 0; right < s.length(); right++){
           //if added correct char to window, update match, if there is a full match update minLen. 
           int curChar = s.charAt(right)-'A';
           current[curChar]++;
           if(want[curChar] >=  current[curChar]){
                match++; 
           }
           while(match == matchTarget){
               if(minLen > (right - left) + 1){
                   minLen = (right -left) +1; 
                   result = s.substring(left, right+1); 
               } 
               int leftMostChar = s.charAt(left) - 'A'; 
               current[leftMostChar]--; 
               left++; 
               if(current[leftMostChar] < want[leftMostChar])
                match--; 


           }
        }
        return result ; 
    }
    public static void main(String[] args) {
        String ans = minWindow("aa", "aa"); 
        System.out.println(ans);

      /*  int beginingVal = 'z' - 'A'; 
        int beginingLowerVal = 'z' +1; 
        System.out.printf("upperbound = %d \nlowerbound = %d", beginingVal, beginingLowerVal); */

    }
    
}
