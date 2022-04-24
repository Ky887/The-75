import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SerializeandDeserializeBinaryTree297 {
    int preStart; 
    Map<Integer, Integer> inorderIndexOf; 
    public String serialize(TreeNode root){ 
        return (dsfPreorder(root).concat("/")).concat(dsfInorder(root));
    }

    public String dsfPreorder (TreeNode root){
        if(root == null) return ""; 

        String mychar = Integer.toString(root.val).concat(","); 
        mychar = mychar.concat(dsfPreorder(root.left)); 
        mychar = mychar.concat(dsfPreorder(root.right)); 
        return mychar; 
    }

    public String dsfInorder (TreeNode root){
        if(root == null) return ""; 
        String mychar = dsfInorder(root.left).concat(Integer.toString(root.val).concat(",")); 
        mychar = mychar.concat(dsfInorder(root.right)); 
        return mychar; 
    }





// expected input (a, a, a, a / b, b, b, b);     
    public TreeNode deserialize(String data){
        if(data.length() == 0 || data == "/") return null; 
        String[] inputs = data.replaceAll(" ", "").split("/"); 
        
        String[] preorderString = inputs[0].split(",");
        String[] inorderString = inputs[1].split(","); 
        int[] preorder = new int[preorderString.length]; 
        int[] inorder = new int[inorderString.length]; 

        // built preorder and inorder arrays from String data 
        for(int i = 0; i<preorderString.length; i++){
            preorder[i] = Integer.valueOf(preorderString[i]); 
            inorder[i] = Integer.valueOf(inorderString[i]); 
        }
        System.out.println(Arrays.toString(preorder));
        System.out.println(Arrays.toString(inorder));


       preStart = 0; 
       inorderIndexOf = new HashMap<>(); 

       for(int i = 0; i < inorder.length; i++){
           inorderIndexOf.put(inorder[i], i); 
       }
      
      
        return helper(preorder, 0, inorder.length-1); 
    }

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
        SerializeandDeserializeBinaryTree297 input = new SerializeandDeserializeBinaryTree297(); 
        TreeNode root = input.deserialize("1, 2, 2 /2, 1, 2"); 
        
        System.out.println(input.serialize(root));
    }
    
}
