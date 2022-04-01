public class InvertBinaryTree226 {
    /*
    Flip my children then call my flipped children what the flip
    reuturn curr node == null. 
    */  
    public TreeNode invertTree(TreeNode root){ 
        flipper(root);
        return root; 
    }

    public void flipper(TreeNode root){
        if(root == null)
            return; 

        TreeNode temp = root.left; 
        root.left = root.right; 
        root.right = temp; 

        flipper(root.left); 
        flipper(root.right); 
    }

    public static void main(String[] args) {
        System.out.println("hello World!!!");
    }
}
