import java.util.Arrays;


public class NonOverlappingIntervals {
    /* 
    Method 1: 
    
   
    Sort the lowerbound of intervals
    Two intervals overlap if current upperbound is larger than next lowerbound. 
    If nextInterval is larger "delete it" by changing its upper bound so the overlap is gone, the same as current. 
    If current interval is larger, safe to ignore and move on to next interval but make sure to still update counter as that would be actually deleted. 
    Update current interval after every iteration. 

    
    
    
    */

    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); 
        int currentInterval = 0; 
        int count = 0; 
        for(int i = 0; i<intervals.length-1; i++){
            int nextInterval = i+1; 
            // if there's an overlap 
            if(intervals[currentInterval][1] > intervals[nextInterval][0]){
               if (intervals[currentInterval][1] < intervals[nextInterval][1]){
               // delete next interval
              // nextInterval = null; 
               intervals[nextInterval][1] = intervals[currentInterval][1]; 
               }   
               count++; 
            } 
              currentInterval = nextInterval; 
            }
        return count; 
    }
    public static void main(String[] args) { 
        int[][] otherInput = {{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}};
        //int[] currentInterval = otherInput[0]; 
    //    currentInterval[1] = 0; 
       // System.out.println(Arrays.deepToString(otherInput));
        System.out.println(eraseOverlapIntervals(otherInput));
    }
    
}
