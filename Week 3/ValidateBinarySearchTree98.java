public class ValidateBinarySearchTree98 {
    public static boolean isValidBST(TreeNode root){
        boolean ans = helper(root, Long.MIN_VALUE, Long.MAX_VALUE); 
        return ans; 
    }

    public static boolean helper(TreeNode root, long min, long max){
        if(root == null){
            return true; 
        }  
        if((root.val <= min) || (root.val >= max))
            return false; 

        return (helper(root.left, min, root.val) && helper(root.right, root.val, max)) ; 
    }
    public static void main(String[] args) {
        TreeNode parent = new TreeNode(2); 
        TreeNode lChild = new TreeNode(1);
        TreeNode rChild = new TreeNode(4); 
        TreeNode node7 = new TreeNode(7); 
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode nodee4 = new TreeNode(4);
        TreeNode nodee7 = new TreeNode(7);

        parent.left = lChild; 
        parent.right = rChild;
        
        lChild.left = node7; 
        lChild.right = node4; 
        
        node7.left = node6; 
        node7.right = nodee4; 
        
        node4.left = nodee7; 
        
        rChild.left = node8; 
        rChild.right = node3; 
        

        System.out.println(isValidBST(parent));
        //  [2147483647]
        // if parent is i, left child = 2i+1 and right child = 2i+2 

    }
    
}
