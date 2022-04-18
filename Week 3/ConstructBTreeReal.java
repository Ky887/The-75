public class ConstructBTreeReal {

    public TreeNode Solution(int[] preorder, int[] inorder){
        
        return helperr(0, 0, inorder.length-1, preorder, inorder); 
    }

    public TreeNode helperr(int preStart, int inStart, int inEnd, int[] preOrder, int[]inorder){
        if(preStart > preOrder.length-1 || inStart > inEnd)
            return null; 
        
        TreeNode root = new TreeNode(preOrder[preStart]); 
        int index = 0; 

        for(int i = 0; i<inorder.length; i++){
            if(root.val == inorder[i])
                index = i; 
        }

        root.left = helperr(preStart+1, inStart, index-1, preOrder, inorder); 
        root.right = helperr(preStart + (index-inStart) +1, index+1, inEnd, preOrder, inorder); 
        return root; 
    }
    public static void main(String[] args) {
        System.out.println("hello world");
    }
    
}
