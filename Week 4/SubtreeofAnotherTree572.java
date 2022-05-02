import java.util.LinkedList;
import java.util.Queue;

public class SubtreeofAnotherTree572 {



    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> breathe = new LinkedList<>();
        breathe.add(root); 
        TreeNode current; 
        while(!breathe.isEmpty()) {
            current = breathe.poll(); 
            if(current.val == subRoot.val)
                if(matchFinder(current, subRoot))
                    return true; 
            if(current.left!= null) breathe.add(current.left); 
            if(current.right!= null) breathe.add(current.right); 
        }   
        return false; 
    }
        
        public boolean matchFinder(TreeNode root, TreeNode subRoot){
            if(root == subRoot) return true; //null case or identical case; 
            
            if(root.val != subRoot.val) return false; 
            
            return (matchFinder(root.left, subRoot.left) && matchFinder(root.right, subRoot.right)); 
            
            
                   
            
        }
    
    
    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree297 treeMaker = new SerializeandDeserializeBinaryTree297(); 
       // TreeNode root = treeMaker.deseralize("[3,4,5,1,2]"); 
        TreeNode root = treeMaker.deseralize("3,4,1,n,n,2,n,n,5,n,n"); 
        TreeNode subRoot = treeMaker.deseralize("4,1,n,n,2,n,n"); 

        SubtreeofAnotherTree572 input = new SubtreeofAnotherTree572(); 
        boolean result = input.isSubtree(root, subRoot);

        System.out.println(result);
    }
}
