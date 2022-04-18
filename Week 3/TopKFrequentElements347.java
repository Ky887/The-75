import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TopKFrequentElements347 {

    /* 
    Method 1: Ghetto Bucket Sort 
        Create a histogram mapping each element in nums to freq (num[i] -> freq)
        Create an array of Arraylists of size nums 
        Match up frequencie's in map to given ArrayList at specified index such that freq = index.
        Add number with matching frequency to ArrayList
        Starting from the max, (records.length-1) find the first nonempty ArrayList,
         add elements to result array and repeat. Once result array is full, return 

    Method 2: Heap Priority Queue Stuff
        Create a histogram mapping each elemnt in nums to freq(nums[i] -> freq)
        Create a heap w priority queue implementation. Tell heap to compare by frequencies 
        (Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> maperino.get(n1)-maperino.get(n2)); 
        Keep only the k top freq elements so as you are iterating through map adding to heap 
        once the size is bigger than k you have to call heap.poll to remove the smallest element. (done w heapsort nlogn)
        Have to call poll n-k times. so O(Nlogk) <O(NlogN)
        Create output array of remaining elements. loop(result[i] = heap.poll)

        swap changes whats in the bucket but not the location of the bucket. 

    Method 3: Quick Select Big brain. Best solution 
        2 Global variables. 
        Map -> Map that maps unique elemenet to their respective freq's
        Unique -> Array of the unique elements which are keys to freq map. 
        Need 3 helper methods, swap and partition
        swap -> swaps two elements in unique array 
        Partition --> partions array acording to left, right and piv index such that everything
        to the left of pivot is less and everything to the right of pivot is greater. Returns new pivotindex. 

        Quick select function calls on sections of itself recursivly until the returned piviot index is n-k. 
        Once the quick select function is done running the unique array has been right sorted for the first k
        positions. safe to just output last k elements of unique array. (return Arrays.copyOfRange(unique, n-k, n))



    
    */ 


    public static int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> maperino = new HashMap<>(); 
        // histogram (distinct number -> freq)
        // better way to do hist. 
       for(int n: nums) {
           maperino.put(n, maperino.getOrDefault(n,0) +1); 
       }
        

        int[] result = new int[k]; 

        // **** Making an array of ArrayLists very interesting****
        //shifting right because want to match up index with frequency..0 index won't be used 
        ArrayList<Integer>[] records = new ArrayList[nums.length+1]; 
       // initiating arrayLists
        for(int i = 0; i < records.length; i++){
            records[i] = new ArrayList<>(); 
        }
        // Matching up frequencie's to given ArrayList at specified index such that freq = index. 
        for(int key : maperino.keySet()){
            records[maperino.get(key)].add(key); 
        }

        int properIndex = records.length-1; 
        int resultIndex = 0; 

        // Starting from the max, (records.length-1)
        //find the first nonempty ArrayList, add elements to result array, repeat/ 
        // Once result array is full, return 
        while(true){
            while(records[properIndex].isEmpty()){
                properIndex--; 
            }
            for(int num: records[properIndex]){
                result[resultIndex] = num; 
                resultIndex++; 
                if(resultIndex >= result.length){ // if result array is full, return 
                    return result; 
                }

            }
            properIndex--; 
        }  
    }
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3, 4, 4, 4} ;

        int[] result = topKFrequent(input, 2); 
        System.out.println(Arrays.toString(result));
    }
}
