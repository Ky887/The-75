
public class LowestCommonAncestoryofaBST253 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        // case root node is at crossroads between nodes q and p
        if((root.val <= p.val && root.val >=q.val) || (root.val >= p.val && root.val <= q.val)){
            return root; 
        }
        if(root.val < p.val)
            return lowestCommonAncestor(root.right, p, q); 
        if(root.val > p.val)
            return lowestCommonAncestor(root.left, p, q); 
        

        return root; 
    }
    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree297 input = new SerializeandDeserializeBinaryTree297(); 
        TreeNode root = input.deseralize("6,2,0,n,n,4,3,n,n,5,n,n,8,7,n,n,9,n,n"); 
        TreePrinter.print(root);

       
       
        /*  LowestCommonAncestoryofaBST253 stuff = new LowestCommonAncestoryofaBST253(); 
        TreeNode p = new TreeNode(3); 
        TreeNode q = new TreeNode(5); 

       System.out.println(stuff.lowestCommonAncestor(root, p, q).val); */

    }
    
}
