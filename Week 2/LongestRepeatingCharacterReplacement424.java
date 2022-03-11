public class LongestRepeatingCharacterReplacement424{
    /*
    Method 1
    Sliding window
    Expand window if it meets the following criteria. 
    window length - # of highest repeating character is less than or equal to k 
    (window.length - hrc <= k )
    If this criteria fails, shrink the window until it becomes true again. 
    Update a maxCounter for window length each time the window grows. 

    maxCount could be some iilegitamate number but for a new lengthMax to occur 
    MaxCount needs to be higher than current maxCount. So it does not need
    to be constantly updated. Only when a new maxCount is encountered.  
    For length of window to increase, maxCount also needs to increase bc windowLen-maxCount <= k 
    */ 

    public static int characterReplacement(String s, int k){
        int[] histo = new int[26]; 

        int left =0, maxCount = 0; 
        int maxLength = 0; 

        for(int right = 0; right< s.length(); right++){
            histo[s.charAt(right)-'A']++; 
            int currentCharCount =  histo[s.charAt(right)-'A']; 
            maxCount = Math.max(maxCount, currentCharCount);  
            // while invariant is false, close window until true again. 
            while((right-left) - maxCount +1 > k){
                // slide window 
                histo[s.charAt(left)-'A']--; 
                left++; 
            }
            maxLength = Math.max(maxLength, (right - left) +1); 
        }
        return maxLength; 
    }

    public static int characterReplacement2(String s, int k){
        int[] histo = new int[26]; 

        int left =0, right = 0; 
        int maxCount = 0; 
        int maxLength = 0;

        while(right < s.length()){
            if((right -left) - maxCount +1 <= k){
                histo[s.charAt(right) - 'A']++; 
                int currentCharCount = histo[s.charAt(right)-'A']; 
                maxCount = Math.max(maxCount, currentCharCount); 
                maxLength = Math.max(maxLength, ((right - left) +1));
                right++;  
            }else{
                histo[s.charAt(left-'A')]--; 
                left++; 
            }
        }

        return maxLength; 
    }
    public static void main(String[] args) {
        String input = "ABAB"; 

        System.out.println(characterReplacement(input, 2));
    }
}