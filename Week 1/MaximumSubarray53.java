public class MaximumSubarray53 {

    /* 
    Method 1:
    Kadane's algorithm. Compare two things. The sum of the 
    current subarray and the current element.
    If the current element is larger then the sum of the current
    subarray including the current element, create a new subarray
    with just the current element. 

    */

    public static int maxSubArray(int[] nums){
        int maxSum = Integer.MIN_VALUE; 
        int curSubArr= 0; 
        for(int i =0; i<nums.length; i++){
            curSubArr+= nums[i]; 
            if(nums[i] > curSubArr)
                curSubArr = nums[i]; 
            maxSum = Math.max(maxSum, curSubArr); 
        }
        return maxSum; 
    }
    public static void main(String[] args) {
        int[] nums = {-2, -1, -3, 4, -1, 2, 1, -5, 4}; 
        System.out.printf("The maximum subarray is %d", maxSubArray(nums));
    }
    
}
