
public class MinimumWindowSubstring76 {
    /* 
    Method 1:
    Sliding window. Can use array histogram or HashMap --> to update HashMap use code: int count = windowCounts.getOrDefault(c, 0); windowCounts.put(c, count + 1);
    1. Start with two pointers left and right pointing to first element
    2. Use the right pointer to expand the window
    3. Once we have a window with all required characters shrink the window from left, while updating minLen
        You know when all the required chars are in window with a matchCounter
        if added char is less or equal to the the charCount of wantHist then you know u made a step in the right direction. (match++)
        shrink left must take into account leftPointer, currHist and match. Adjust those approprietly with respect to the chars lost from window. 
    4. If the window is not desirable anymore, repeat step 2 and expand the window untill loopinvariant restored. 
    */ 
    public static String minWindow(String s, String t){
        if(s.length() < t.length()){
            return ""; 
        }
        
        int left = 0, right = 0; 
        int match = 0; 
        int matchTarget = (int) t.chars().distinct().count();
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
           if(want[curChar] ==  current[curChar]){
                match++; 
           }
           while(match == matchTarget){
               if(minLen > (right - left) + 1){
                   minLen = (right -left) +1; 
                   result = s.substring(left, right+1); 
               } 
               // shrinking window 
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
