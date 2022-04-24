
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TopKFrequentElementsQuickSelectSol347 {

    TopKFrequentElementsQuickSelectSol347(){
        System.out.println("starting up brother");
    }
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
        (Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> count.get(n1)-count.get(n2)); 
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

    Map<Integer, Integer> count; 
    int[] unique; 

    public int[] topKFrequent(int[] nums, int k){

        // histogram (distinct number -> freq)
       count = new HashMap<>();
       for(int n: nums) {
           count.put(n, count.getOrDefault(n,0) +1); 
       }

       // initating unique array with keys to count Map
       unique = new int[count.size()]; 
       int n = unique.length;  
       int j =0; 
       for(int num: count.keySet()){
           unique[j++] = num; 
       }
       // calling recursive function
       quickSelect(0, n-1, n-k);
       return Arrays.copyOfRange(unique, n-k, n); 

       
    }
    public void quickSelect(int left, int right, int k_index){
        //base case
        if (left == right)
            return; 
        // selecting random pivot 
        int piv_index; 
        Random ran = new Random(); 
        piv_index = left + ran.nextInt(right-left+1); 
        piv_index = partion(left, right, piv_index); 

        // if pivot is in n-k position the k largest elements are to the right of pivot
        if(piv_index == k_index){
            return; 
        }else if(piv_index < k_index){
            quickSelect(piv_index+1, right, k_index);
        }else{
            quickSelect(left, piv_index-1, k_index);
        }

    }
    public void swap(int a, int b){
        int temp = unique[a]; 
        unique[a] = unique[b]; 
        unique[b] = temp; 
    }
// Forces array to satisfy variant for a given pivot. 
// Everything to the left is less than and everything to the right is greater than. 

    public int partion(int left, int right, int piv_index){
        swap(piv_index, right); 
        int swap_index = left; 

        for(int i = left; i<= right; i++){
            if(count.get(unique[i]) < count.get(unique[right])){
                swap(i, swap_index); 
                swap_index++; 
            }
        }
        swap(right, swap_index); 


        return swap_index; 
    }
        

       
    public static void main(String[] args) {
        int[] input = {1, 1, 1, 2, 2, 3, 4, 4, 4} ;


        TopKFrequentElementsQuickSelectSol347 stuff = new TopKFrequentElementsQuickSelectSol347(); 
        int[] result = stuff.topKFrequent(input, 2);  
        System.out.println(Arrays.toString(result));
    }
}
