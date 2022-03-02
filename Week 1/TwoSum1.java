import java.util. * ; 


public class TwoSum1{

    /* 
    Method 1: 
    Double loop iterating through each match to find it's compliement
    This is the brute force method. Run time is O(n^2). 

    Method 2:
    Using the MAP data structure Where the values are keys 
    and their indexes are values. For each element in array it creates a 
    compliment value (target - nums[i]), then checks if the MAP contains they 
    compliment as a key. If it does it returns the index of both. If not it 
    stores the value nums[i], and the key index i in MAP. 
    This method has run time O(n). 
    
    */ 

    public static int[] twoSum (int[] nums, int target){

        Map<Integer, Integer> holder = new HashMap<>(); 
        
        for(int i = 0; i< nums.length; i++){
            int compliement = target - nums[i]; 
            if(holder.containsKey(compliement)){
                return new int[] {i, holder.get(compliement)}; 
            } else{
                holder.put(nums[i], i); 
            }
        }
         

        return new int[] {-1, -1}; 
        
    }


    public static void main(String[] args) {

        int[] stuff = {2, 7, 11, 15}; 
        int[] ans = twoSum(stuff, 9); 

        System.out.println(Arrays.toString(ans));

        
    }
}