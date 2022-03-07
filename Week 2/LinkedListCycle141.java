public class LinkedListCycle141 {
    /*
     Method 1: Floyd's Tortoise & Hare
        Slow and fast pointer method. slow pointer moves at 1x while fast at 2x.
        During each iteration fast pointer will be one position closer (+1 -2 = -1). 
        So this alglorith is designed by N-1 = O(n). It will take at most n times for 
        slow and faster pointers to be at the same position. 

        Two pointers at diffenet speeds, if they meet there's a loop
    
    */ 

    public static boolean hasCycle(ListNode head){

        if (head == null)
            return false; 

        ListNode fast = head; 
        ListNode slow = head; 

        while(fast != null && fast.next != null){
            slow = slow.next; 
            fast = fast.next.next; 

            if(fast == slow){
                return true; 
            }
        }


        return false; 
    }
    public static void main(String[] args) {
        
    }
    
}
