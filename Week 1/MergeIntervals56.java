import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    /*
    Method 1:
    Sort the array based on low values. First create an output arrayList (list instead of [] because we do not know the size of the structure before hand) 
    and add the first interval on to it. Iterate through the input 
    array and compare the current high value with the next low value.
    If the current high value is larger then the next low, merge 
    the two intervals by taking the max of both interval max values. 
    If the current high is lower then the next_low, set the current interval
    to be the next interval and add it into your output array. 
    
    */ 

    public static int[][] merge(int[][] intervals){

        Arrays.sort(intervals, (arr1, arr2) -> Integer.compare(arr1[0], arr2[0])); 
        List<int[]> output_arr = new ArrayList<>(); 

        int[] current_interval = intervals[0];
        output_arr.add(current_interval);  
        // First iteration is going to compare the first interval with itself, 
        // This is fine because code can handle dublicates, the end result is 
        // current_interval[1] = Math.max(current_high, current_high); 

        for(int[] interval: intervals){
           // int current_low = current_interval[0]; 
            int current_high = current_interval[1]; 
            int next_low = interval[0]; 
            int next_high = interval[1]; 

            if(current_high >= next_low)
                current_interval[1] = Math.max(current_high, next_high); 
            else{
                current_interval = interval; 
                output_arr.add(current_interval);
            } 
        }

        return output_arr.toArray(new int[output_arr.size()][]); 

    }
    public static void main(String[] args) {
        int[][] input = {{1, 3}, {2, 6}, {8, 10}, {9, 18}}; 

        System.out.println(Arrays.deepToString(merge(input)));
        
    }
    
}
