import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree297 {
 
    public String serialize(TreeNode root){
        if(root == null){
            return "null,";  
        }
       // String leftSerilize = serialize(root.left);
        //String rightSerilize = serialize(root.right);

        return Integer.toString(root.val)+ "," + serialize(root.left)+serialize(root.right) ;

       // String cereal = dsfDismantler("",root);  

       // return cereal; 
    }

    public TreeNode deseralize(String data){    
        Queue<String> input = new LinkedList<>(Arrays.asList(data.split(","))); 
        TreeNode root = dsfBuilder(input); 

        return root; 
    }

    public String dsfDismantler(String cereal, TreeNode root){
        if(root == null){
            cereal = cereal.concat("null,"); 
            return cereal;  
        }
        cereal = cereal.concat(Integer.toString(root.val).concat(",")); 
        cereal = dsfDismantler(cereal, root.left); 
        cereal = dsfDismantler(cereal, root.right); 

        return cereal; 

    }

    public TreeNode dsfBuilder(Queue<String> input){
        String curr = input.poll(); 
        if(curr.equals("n")){
            return null; 
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(curr)); 

        root.left = dsfBuilder(input); 
        root.right = dsfBuilder(input); 

        return root; 
    }
    public static void main(String[] args) {
        SerializeandDeserializeBinaryTree297 input = new SerializeandDeserializeBinaryTree297(); 
        TreeNode root = input.deseralize("1,2,n,n,3,4,n,n,5,n,n"); 
        System.out.println(input.serialize(root));
    }
    
}
