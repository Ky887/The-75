import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    /* 
    Method 1: 
    Create a hashset, check is number is in hashset, if it is return false.
    If it's not in hashset throw the number in the set. If you reach the end of 
    the input return true. O(n)
    

    Method 2: 
    Sort the array using arrays.sort. Then check if the element and the method adjacent
    to it are both equal. If they are return true. If you reach to the end of the array return false. 



    If prioritizing time, use method 1. If prioritizing space, use method 2. 
    */

    public static boolean containsDuplicate(int[] nums){

        Set<Integer> stuff = new HashSet<>(); 

        for(int i=0; i<nums.length; i++){
            if(stuff.contains(nums[i])){
                return true; 
            }else{
                stuff.add(nums[i]); 
            }
        }

        return false; 
    }

    public static void main(String[] args) {
        int[] dummy  = {1, 2, 3, 4}; 
        int[] dummy2 = {1, 2, 3, 1}; 


        System.out.println(containsDuplicate(dummy));
        System.out.println(containsDuplicate(dummy2));
    }
    
}
