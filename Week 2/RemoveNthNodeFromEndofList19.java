public class RemoveNthNodeFromEndofList19 {
/* 


    General Solution
        Create a dummy node and have it point to head. Set fast and slow to dummy node. 
        Move fast up link list n+1 times. Then move both fast and slow in unison. 
        When fast = null, fast is at the end of the list and slow is pointing to the node
        right before the target node. Point slow to the next.next node to delete target node. 

*/

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 

        ListNode slow = dummy; 
        ListNode fast = dummy;  
        // want fast pointer n+1 steps ahead so can have slow.next pointer in postition to skip the nth node from end. 
        for(int i = 0; i < n+1; i++){
            fast = fast.next;
        }
       // Traverse both pointers simultaneously into position 
        while(fast != null){
            slow = slow.next; 
            fast = fast.next; 
        }    
        // once in position, have slow pointer skip the desired node.  
        slow.next = slow.next.next ; 
        return dummy.next; 
    }

    public static void main(String[] args) {
        ListNode ans; 
        ListNode head = new ListNode(1); 
        head.next = new ListNode(2); 
        head.next.next = new ListNode(3); 
        head.next.next.next = new ListNode(4); 
        ans = removeNthFromEnd(head, 2); 

        while(ans!= null){
            System.out.println(ans.val);
            ans = ans.next; 

        }


    }
}
