import java.util.HashMap;
import java.util.Map;

public class CloneGraph113 {

    /*
    Method 1: 
    Using recursive method Cloner. 
    Create clone of incoming node and add it to global hashMap 
    then for each neighbour of that node  call back on itself to repeat process, 
    base case is when you encounter a node already in hashmap. That means 
    The node and it's neighbours have already been visited so just return the address
    of the cloned node, for the given node asking for it. After visiting all it's neighbours 
    return. 
    
    */
    Map<Node, Node> map = new HashMap<>(); 

    public Node cloneGraph(Node node){
        Node result = cloner(node); 
        return result; 
    }

    public Node cloner(Node node){
        // base case. If node is already in key that means we've already visited it 
        // and it's neighbours so just return the address of the clone for the node asking 
        // for it. 
        if(map.containsKey(node))
            return map.get(node); 

        Node dummy = new Node(node.val); 
        map.put(node, dummy); 

        for(Node neighbour: node.neighbors){
            dummy.neighbors.add(cloner(neighbour)); 
        }

        return dummy; 
    }
    public static void main(String[] args) {
        System.out.println("hello motha sucka");
    }
    
}
