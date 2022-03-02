import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Method 1: 'a', 'b', 'c' == 0; 
Sort array with Arrays.sort. Iterate through the input having a fixed a value. Run twoSumII 
on the other part of the array. While iterating through input skip any duplicates so 'a' value
is fixed only once. (i == 0 || nums[i] != nums[i-1]). 
While running twoSumII, have to take into account duplicate 'b' and 'c' values.
(while nums[low] == nums[low-1]) low++;. Only have to change low value and the algorithm will change
the other value inorder to compute the correct sum. 
*/

public class ThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); 
        Arrays.sort(nums);

        for(int i= 0; i < nums.length-2; i++){
            if(i==0 ||(i >0 && nums[i] != nums[i-1])){
                int low = i + 1; 
                int high = nums.length-1; 
                int sum = nums[i] *-1; 
                // Modified twoSumII
                while( low < high){
                    if (nums[low] + nums[high] == sum){
                        ans.add(Arrays.asList(nums[i], nums[low], nums[high])); 
                        low++; 
                        high--; 
                        while(low < high && nums[low] == nums[low-1]) low++;  
                    } else if(nums[low] + nums[high] > sum){
                        high--;  
                    }else{
                        low++; 
                    }
                }
            }
        }
        return ans; 
    } 
        
    
   
    public static void main(String[] args) {
        int[] input = {-1, 0, 1, 2, -1, -4}; 

        List<List<Integer>> output = threeSum(input); 
        System.out.println(output.toString());

      /*  for(List<Integer> stuff: output){
            System.out.println(stuff.toString());
        } */
        
    }
    
}