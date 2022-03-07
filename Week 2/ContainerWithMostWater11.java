public class ContainerWithMostWater11 {
    /* 
    Method 1: O(n)

    Have two pointers at opposite ends of the array. Move minimum pointer of the two inwards. If pointers
    are the same move either one. Update maxArea during each iteration. 
    */


    public static int maxArea(int[] height){
        int maxA = 0; 
        int left = 0; 
        int right = height.length-1; 

        while(left < right){
            maxA = Math.max(maxA, ((right-left) * Math.min(height[left], height[right]))); 
            if(height[left] <= height[right]){
                left++; 
            }else {
                right--; 
            }
        }

        return maxA; 
    }
    public static void main(String[] args) {
        int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7}; 

        System.out.println(maxArea(input));
        
    }
    
}
