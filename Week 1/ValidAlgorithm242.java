import java.util.Arrays;

public class ValidAlgorithm242 {
    /*
        Method 1:O(n)
        Create histograms for both strings using integer arrays. 
        Compare to see if the arrays are equal 

        Method 2: O(n) 
        Have on histogram which records the diffence in frequncies for 
        both inputs. When it comes acrosss a letter is s ++, in t--. 
        Then loop throught the histogram and if an element is not 0,
        you know there is a differnce in frequencies and they are not
        anagrams. 
    */ 

    public static boolean isAnagram(String s, String t){
       

        if(s.length() != t.length())
            return false; 
   // Histograms for both sting s and t. 
        int[] sFreq = new int[26]; 
        int[] tFreq = new int[26]; 

        for(int i = 0; i<s.length(); i++){
            sFreq[(s.charAt(i)-'a')]++; 
            tFreq[(t.charAt(i)-'a')]++; 
        }




        return Arrays.equals(sFreq, tFreq); 
    }
    public static void main(String[] args) {
        String thing1 = "anagram"; 
        String thing2 = "nagaram"; 


        System.out.println(isAnagram(thing1, thing2));
    }
}
