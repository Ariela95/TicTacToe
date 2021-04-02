package tasks;
  
// This class represents a directed graph using adjacency 
// list representation 
public class Tasks 
{ 
    private int num;   // No. of vertices 
    private int[][] taskArr; // Adjacency List 
  
    //Constructor 
    public Tasks (int num) 
    { 
        this.num = num; 
        this.taskArr = new int[num][num]; 
        for (int i=0; i<num; ++i) 
        	for(int j=0; j<num; j++)
        		this.taskArr[i][j] = -1; 
    } 
  
    // Function to add an edge into the graph 
    public boolean dependsOn(int task1, int task2) {
    	if(task1>num || task2>num)	return false;
    	for(int j=0; j<num;j++)
    	{
    		if(this.taskArr[task2][j] == -1)
    		{
    			this.taskArr[task2][j] = task1;
    			return true;
    		}
    	}
    	return false;
    }
  
    // The function to do Topological Sort. It uses 
    // recursive topologicalSortUtil() 
    public int[] order()
    { 
        int[] res = new int[this.num];
        boolean cycle = false;
        boolean searchDep[] = new boolean[this.num]; 
        for (int i = 0; i < this.num; i++) 
        {
        	searchDep[i] = false;  // initialize to false value
        	res[i] =-1;
        }
        
        for (int i = 0; i < this.num; i++) 	// for each element, push it's dependencies to stack
            if (!searchDep[i]) 		// handles duplicates
            {	
            	cycle = checkTasks(res, searchDep, i); 
            	if(cycle)	return null;
            }
        return res;
    }
    
    /* A private function for pushing tasks into the given stack according to dependencies*/
    private boolean checkTasks(int[] res, boolean searchDep[], int num) 
    { 
    	int i=0; 
    	searchDep[num] = true; // if reached here, the current task will be pushed to the stack, therefore handled 
        
        
         //Iterator<Integer> it = this.taskArr[num].iterator();
        while(i<this.num)//it.hasNext()) 
        {  
           if(this.taskArr[num][i] == -1)
           {
        	   i++;
        	   continue;
           }
        	if (!searchDep[this.taskArr[num][i]]) 
            	checkTasks(res, searchDep,this.taskArr[num][i]); 
        	i++;
        } 
  
       for(int ofst = this.num-1; ofst>=0;ofst--)
       {
    	   if(res[ofst]==-1)
    	   {
    		   res[ofst] = num;
    		   break;
    	   }
    	   if(res[ofst] == num)	return true;
       }
       return false;
    } 
}