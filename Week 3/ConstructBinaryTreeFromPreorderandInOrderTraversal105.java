import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderandInOrderTraversal105 {

    /* 
    
    Method 1: Inorder index Map, two global variables 

    preStart and map are global variables 
    preStart denotes where the root node is in preorder array

    Have a value -> index relation of the inorder array. 
    So when at a given root, very easy to give each side of range to your children:
    index = inorderIndexMap.get(preorder[prestart++]); 
    (inStart, index-1) and (index+1, inEnd) are the two ranges to be passed on. 

    helper method has signature helper(int[] preorder, int inStart, int inLeft). 


    Method 2: Find inorderIndex of root, pass on to left and right children with arithmetic. 

    Same idea as method one but instead given signature 
    helper(int preStart, int inStart, int inEnd, int[] preorder, int[]inorder)
    you need to find inorderindex of root (preStart) at every node w/ simple for loop 

    pass on to left child with just setting preStart to preStart+1 and the left side of range. (start, index-1)
    pass on right child with arithmetic fact that the immediate right node will happen after all the left nodes
    have been reached. So right child will be preStart + (index-inStart)+1. 

    */ 
    int preStart; 
    HashMap<Integer, Integer> inorderIndexOf; 

    public TreeNode buildTree(int[] preorder, int[] inorder){
       preStart = 0; 
       inorderIndexOf = new HashMap<>(); 

       for(int i = 0; i < inorder.length; i++){
           inorderIndexOf.put(inorder[i], i); 
       }
      
      
        return helper(preorder, 0, inorder.length-1); 
    }
  /*
    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart > preorder.length-1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]); 

        int inIndex = 0; 
        for(int i = inStart; i <inEnd; i++){
            if(root.val == inorder[i]){
                inIndex = i; 
            }
        }

        root.left = helper(preStart +1, inStart, inIndex-1, preorder, inorder); 
        root.right = helper(preStart + (inIndex-inStart) +1 , inIndex+1, inorder.length-1, preorder, inorder); 
       
        return root; 
        
    }  */

    public  TreeNode helper(int[] preorder, int inStart, int inEnd){
        if(preStart > preorder.length-1 || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preorder[preStart]); 
        int inIndex = inorderIndexOf.get(preorder[preStart++]); 

        
        root.left = helper(preorder, inStart, inIndex-1);
        root.right = helper(preorder, inIndex+1 , inEnd); 
       
        return root; 
        
    }
    
    public static void main(String[] args) {
        System.out.println("is this shit on");
    }
    
}
