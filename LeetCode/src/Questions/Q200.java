package Questions;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * 	Example 1:
	11110
	11010
	11000
	00000	
	Answer: 1

	Example 2:	
	11000
	11000
	00100   (2,3)  2 * 5 +¡@ 3 = 13
	00011
	Answer: 3
 */


class Q200 {
    public int numIslands_dfs(char[][] grid) {
    	int res = 0;
        int m = grid.length;
        if(m==0) return 0 ;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(grid[i][j] == '1')
        		{
        			dfs(grid,i,j);
        			res++;
        		}
        	}
        }
        return res;
    }
    
    public void dfs(char[][] grid, int i,int j)
    {
    	if(i < 0 || j < 0 || i >=grid.length || j >= grid[0].length || grid[i][j]=='0') return;
    	grid[i][j] = '0';
    	dfs(grid,i-1,j);
    	dfs(grid,i+1,j);
    	dfs(grid,i,j-1);
    	dfs(grid,i,j+1);
    }
    
    
    /*
     *  Using BFS
     *  
     */
    public static int numIslands_bfs(char[][] grid) 
    {
    	int res = 0;
        int m = grid.length;
        if(m==0) return 0 ;
        int n = grid[0].length;
        
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		if(grid[i][j] == '1')
        		{
        			bfs(grid,i,j);
        			res++;
        		}
        	}
        }
        return res;
    }
    
    public static void bfs(char[][] grid, int i, int j)
    {
    	grid[i][j] = '0';
    	Queue<Integer> queue = new LinkedList<>();
    	int m = grid.length;
    	int n = grid[0].length;
    	int code = i * n + j;
    	queue.offer(code);
    	while(!queue.isEmpty())
    	{
    		code = queue.poll();
    		int x = code / n;
    		int y = code % n;
    		
    		if(x > 0 && grid[x-1][y] == '1')
    		{
    			queue.offer((x-1)*n+y);
    			grid[x-1][y] = '0';
    		}
    		if(x < m-1 && grid[x+1][y] == '1')
    		{
    			queue.offer((x+1)*n+y);
    			grid[x+1][y] = '0';
    		}
    		if(y > 0 && grid[x][y-1] == '1')
    		{
    			queue.offer(x*n+y-1);
    			grid[x][y-1] = '0';
    		}
    		if(y < n-1 && grid[x][y+1] == '1')
    		{
    			queue.offer(x*n+y+1);
    			grid[x][y+1] = '0';
    		}
    		
    	}
    }
    
    
	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		int result = numIslands_bfs(grid);
		System.out.println(result);
	}
}
