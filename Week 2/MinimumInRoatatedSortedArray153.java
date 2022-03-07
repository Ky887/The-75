public class MinimumInRoatatedSortedArray153 {

    /*
    Method 1:
    Which side of the pivot am I on? (Find the position right after the pivot)
    Same as binary search except the behaviour is different 
    depending if the pivot is between left and mid. 
    First check if sorted(if nums[left] < nums[right]); If sorted return min(nums[left], min)
    The pivot is between left and mid if nums[left] > nums[mid]. 
    Then everything in the right half will be bigger than nums[mid] so we can discard it. 
    If the pivot is not present between nums[left] and nums[mid] then it is on the 
    the other side of the array, and the minimum is the element right after the pivot 
    so you can discard the left half of the array. (since we check if the array is sorted we
    know that the pivot can't be in the last spot) 
    
    */ 

    public static int findMin(int[] nums){

        if(nums.length == 1)
            return nums[0]; 
      
        int left = 0; 
        int right = nums.length-1;
        int min = Integer.MAX_VALUE; 

        while(left <= right){
            if(nums[left] < nums[right])
                return Math.min(min, nums[left]); 
            int mid = left + (right-left)/2; 
            min = Math.min(min, nums[mid]); 
            if(nums[left] <= nums[mid]){
                left = mid+1; 
            }else{
                right = mid-1; 
            }
        }
        return min;  
    }
    public static void main(String[] args) {

        int[] input = {4, 5, 1, 2, 3}; 
        System.out.println(findMin(input));
        
    }
    
}
