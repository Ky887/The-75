public class BuyandSellStock121{
    public static int maxProfit(int[] prices){

        /* 
            Method 1:
            Relies on the fact that when moving across input we only 
            need to keep track of the minimum number encoutered while 
            comparing that with the current difference between that number and
            prices[i]. Store the largest difference encouterd into 
            variable maxPro. If a new minimum is encountered the min variable is reset 
            and maximum comparisons will be made from that point on in respect with the 
            new min. After each element that isn't a new minimum, compare the difference
            between (min and prices[i]) and maxPro and store the larger into maxPRo. 
        

            Hey y'all did you get this change, im new to the gitty 

            Hey i'm testing branches so lets see if i added a new branch 


        */

        int min = Integer.MAX_VALUE; 
        int maxPro = 0; 

        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i]; 
            } else if(prices[i] - min > maxPro){
                maxPro = prices[i] - min; 
                
            }

        }

        return maxPro; 
    }
    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4}; 
        int ans = maxProfit(nums); 

        System.out.println(ans);
        
    }

}