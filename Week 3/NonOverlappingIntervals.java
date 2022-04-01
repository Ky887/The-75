import java.util.Arrays;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class NonOverlappingIntervals {
    /* 
    Method 1:
    burte force is for every thing remove or keep 2^n time complexity 
    instead use greedy approach. 
    
    Iterate them sorted. Sort the lowerbound of intervals
    Know if they are overlapping if they have same starting point or the first one starts before the second
    one ends. (If second one starts before the first one ends.)

    Incase of overlap would want to keep the one that ends first to lower the chances of further 
    overlaps
    
    
    */

    public static int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); 
        int[] currentInterval = intervals[0]; 
        int count = 0; 
        for(int i = 0; i<intervals.length-1; i++){
            int[] nextInterval = intervals[i+1]; 
            int j = 1; 
            // if current interval is deleted roll back untill you reach a real interval to compare with nextInterval
            while(currentInterval == null){
                currentInterval = intervals[i-j]; 
                j++;   
            }
            // if there's an overlap 
            if(currentInterval[1] > nextInterval[0]){
               if (currentInterval[1] < nextInterval[1])
               // delete current interval
              // nextInterval = null; 
               intervals[i+1] = null; 
               else
                    // currentInterval = null; 
                     intervals[i] = null; 
               count++; 
            }
            currentInterval = intervals[i+1]; 
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
