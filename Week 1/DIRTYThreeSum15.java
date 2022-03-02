import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Method 1:
Sort array with Arrays.sort. Then iterate through 
input and for each element call the twoSum helper method 
that used two pointers, with the target being the complement


*/

public class DIRTYThreeSum15 {

    public static List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> ans = new ArrayList<List<Integer>>(); 
        Arrays.sort(nums); 
        
        for(int i = 0; i < nums.length-2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int target = nums[i] * -1; 
                List<Integer> duh = twoSumHelper(nums, i, target); 
                if(duh.get(0) != -1){
                    ans.add(Arrays.asList(nums[i], nums[duh.get(0)], nums[duh.get(1)])); 
                }
            }           
        }
        return ans;       
    }
    // Returns index of two elements that equal target, otheriwse returns {-1, -1}
    public static List<Integer> twoSumHelper(int[] input, int curr, int target){
        int left = 0; 
        int right = input.length-1;
        List<Integer> output = Arrays.asList(-1, -1);  
        while(left < right){
            int sum = input[left] +input[right]; 
            if((sum == target) && !(left != curr || right != curr)){
                return Arrays.asList(left, right); 
            }else if(sum > target){
                right--; 
            }else{
                left++; 
            }
        }
        return output; 
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
