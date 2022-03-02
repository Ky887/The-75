import java.util.Arrays;

public class ProductofArrayExceptSelf238 {

    /*
    Method 1: Using division, calculate the total product 
    and divide the product by the current element to get the ans. 
    Have to implement checks for the case where the element is zero. 
    Can't divide by zero. 


    Method 2: 
    Create two subarrays toTheLeft and toTheRight which represent
    the products to the right and and left of each element. Multiply
    Both subarrays at a given index to find the result for the given index
    and place resultant in new array. 

    Method 3:
    Same as method two but only one output array. Proceed with creating the array
    to represent toTheLeft. Now instead of creating another to represent toTheRight
    have that be represented in a running product variable right. (right  = nums[i+1]*right)
    Then multiply right with the current element on a given index. (output[i] = output[i]*right)
    */
    public static int[] productExceptSelf(int[] nums){
        int[] ans = new int[nums.length]; 

        // defining toTheLeft array 
        ans[0] = 1; 
        for(int i = 1; i < nums.length; i++)
            ans[i] = nums[i-1] * ans[i-1]; 
        // defining toTheRight while using a variable to 
        // represent the old right product and multplying
        // that value by the coressponding toTheLeft element

        int right = 1; 
        for(int i = nums.length-1; i >= 0; i--){
            ans[i] = right * ans[i]; 
            right = nums[i]*right; 

        }
            
    
        return ans; 
    }
   
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5}; 
        int [] ans = productExceptSelf(input); 
        System.out.println(Arrays.toString(ans));   
    
    }

    /* 
     public static int[] productExceptSelf(int[] nums){
        int[]toTheLeft = new int[nums.length]; 
        int[]toTheRight = new int[nums.length]; 
        int[] ans = new int[nums.length]; 

        toTheLeft[0] = 1; 
        toTheRight[nums.length-1] = 1; 

        for(int i = 1; i < nums.length; i++)
            toTheLeft[i] = nums[i-1] * toTheLeft[i-1]; 
        for(int i = nums.length-2; i >= 0; i--)
            toTheRight[i] = nums[i+1] * toTheRight[i+1]; 
        for(int i =0; i< nums.length; i++)
            ans[i]= toTheLeft[i] * toTheRight[i]; 

        return ans; 
    }
    
    */

    /*
     public static int[] productExceptSelf(int[] nums){
        int product = 1; 
        int zeroCounter = 0;  
        int[] ans = new int[nums.length]; 

        for(int i =0; i<nums.length; i++){
            if(nums[i] == 0)
                zeroCounter++; 
            else
                product*= nums[i];         
        }

        for(int i = 0; i< ans.length; i++){
            switch(zeroCounter){ 
                case 0:
                    ans[i] = product/nums[i];  
                    break; 
                case 1:
                    if(nums[i] == 0)
                        ans[i] = product; 
                    break;
                default:
                    return ans; 
            } 
        }
        return ans; 
    } 
    */ 
}
