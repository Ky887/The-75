public class ReverseLinkedList206 {
    public static ListNode reverseList(ListNode head){

        return head; 



    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1); 
        ListNode curr = head; 
        for(int i = 2; i < 6; i++){
            ListNode blah = new ListNode(i); 
            curr.next = blah; 
            curr = curr.next; 
        }
       ListNode ans = reverseList(head); 
        while(ans != null){
            System.out.println(head.val);
            head = head.next;      
        }
    
    }
}
