import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule207{
   List<Integer>[] map;  
   boolean[] visited; 
   boolean[] taken; 

    public boolean canFinish(int numCourses, int[][] prerequisites){
        visited = new boolean[numCourses]; 
        taken = new boolean[numCourses]; 
        map = new ArrayList[numCourses]; 
        
      // Initalizing empty arrays for each key 
        for(int k = 0; k < numCourses; k++){
            ArrayList<Integer> dummy = new ArrayList<>(); 
            map[k] = dummy;  
        }
    //Converting 2D array into adjancey list. course -> it's prereqs 
        for(int[] edge: prerequisites){
            map[edge[0]].add(edge[1]); 
        }
    // logic to skip courses already taken     
        for(int i = 0; i < numCourses; i++){
            if(!taken[i] && helper(i) == false) return false; 
        }
        return true; 
    }

    public boolean helper(int currentCourse){
        // This is to prevent cycles, if already visited node then cycle present. 
       /* if(visited.contains(currentCourse)){
            return false; 
        } */
        if(visited[currentCourse] == true) return false; 
        // if course has no prerequrisites return true; 
        if(map[currentCourse].isEmpty()){ 
            return true; 
        }
        // add current course to visited 
        visited[currentCourse] = true; 
        // bubble up the false if any I can't take any of my prerequisites 
        for(int prerequisite: map[currentCourse]){
           if(!helper(prerequisite))
            return false; 
        }
        // loop testing: If i sent you and you came back to me RED FLAGG, but another node reaching me is fine.  
        visited[currentCourse] = false; 
        taken[currentCourse] = true; 
        map[currentCourse].clear(); 
        return true;  
    }
    public static void main(String[] args) {
        int [][] input = {{1, 0}, {0, 1}}; 
        CourseSchedule207 thing = new CourseSchedule207(); 
        System.out.println(thing.canFinish(2,input));
    }
}