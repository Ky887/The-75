public class BinaryTreeMaxPathMaxSum124 {

    /* 
    Get the max path of left and right subtree (x,y)
    compute splitMax --> If the split is at current node so left subtree + root + right subtree
    update globalMax --> Integer.max(globalMax, splitMax)
    To avoid having too large an int when doing splitMax if x or y is less than zero just set them to zero because a number minus any integer will be smaller.(therefore not max)
    Send the correct max path upwards to parent nodes --> Integer.max(0, Integer.max(x, y))

    */ 

    int globalMax;  

    public int maxPathSum(TreeNode root){
        globalMax = Integer.MIN_VALUE; 
        dsf(root); 
        return globalMax; 
    }

    public int dsf(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE; 
        }
        int currMax;
        int x = (dsf(root.left)); 
        int y = (dsf(root.right)); 
        currMax = Integer.max(0, Integer.max(x, y)); 
        if(y < 0 ) y = 0; if(x <0) x = 0; 
        globalMax = Integer.max(globalMax, root.val + x + y); 
        
        return root.val+currMax; 
    }
    public static void main(String[] args) {

        
        SerializeandDeserializeBinaryTree297 treeMaker = new SerializeandDeserializeBinaryTree297(); 
       // TreeNode root = treeMaker.deseralize("-10,9,null,null,20,15,null,null,7,null,null"); 
        TreeNode root = treeMaker.deseralize("5,4,11,7,n,n,2,n,n,n,8,13,n,n,4,n,1,n,n"); 

       // System.out.println(root.val);
        BinaryTreeMaxPathMaxSum124 input = new BinaryTreeMaxPathMaxSum124(); 
       // System.out.println(input.globalMax);

        System.out.println(input.maxPathSum(root)); 

    }
    
}

