import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Method 1:
Place the first array into the output array[][]. Iterate through input array 
creating a histogram array for each. If the histograph of both the current stringi 
and the newly placed string on the output_Arr match, add the current string to the on output array. 
If no matches grow list size and add new array entry. 


Method 2:
Sort the words. All anagrams will be equal at this point. Map the sorted words
to all it's anagrams. With the sorted word being the key. 
*/ 

public class GroupAnagrams49 {

    public static List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> output_arr = new ArrayList<>(); 
        Map<String, ArrayList<String>> map = new HashMap<>(); 

        for(String current: strs){
            char[] tochar = current.toCharArray(); 
            Arrays.sort(tochar);
            String sorted = new String(tochar);  

            if(!map.containsKey(sorted))  
                map.put(sorted, new ArrayList<>()); 

            map.get(sorted).add(current); 

        }
        output_arr.addAll(map.values()); 

        return output_arr; 
    }
    public static void main(String[] args) {
        
    }
    
}
