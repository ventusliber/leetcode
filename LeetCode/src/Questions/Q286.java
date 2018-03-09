package Questions;

import java.util.LinkedList;
import java.util.Queue;

public class Q286 {

	public void wallsAndGates_dfs(int[][] rooms)
	{
		int m = rooms.length;
		if(m < 0) return;
		int n = rooms[0].length;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(rooms[i][j] == 0)
				{
					dfs(rooms,i,j,0);
				}
			}
		}
	}
	
	public void dfs(int[][] rooms,int i, int j, int d)
	{
		if(i < 0 || j < 0 || i >= rooms.length || j >=rooms[0].length || rooms[i][j] < d) return ;
		rooms[i][j] = d;
		
		dfs(rooms,i+1,j,d+1);
		dfs(rooms,i-1,j,d+1);
		dfs(rooms,i,j-1,d+1);
		dfs(rooms,i,j+1,d+1);
	}
	
	public void wallsAndGates_bfs(int[][] rooms)
	{
		Queue<int[]> queue = new LinkedList<>();
		int m = rooms.length;
		if(m < 0) return;
		int n = rooms[0].length;
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(rooms[i][j] == 0)
				{
				   queue.offer(new int[]{i,j});	
				}
			}
		}
		
		while(!queue.isEmpty())
		{
			int[] top = queue.poll();
			int i = top[0], j = top[1];
			
			if(i>0 && rooms[i-1][j] == Integer.MAX_VALUE)
			{
				rooms[i-1][j] = rooms[i][j] + 1;
				queue.offer(new int[] {i-1,j});
			}
			if(i<rooms.length && rooms[i+1][j] == Integer.MAX_VALUE)
			{
				rooms[i+1][j] = rooms[i][j] + 1;
				queue.offer(new int[] {i+1,j});
			}
			if(j>0 && rooms[i][j-1] == Integer.MAX_VALUE)
			{
				rooms[i][j-1] = rooms[i][j] + 1;
				queue.offer(new int[] {i,j-1});
			}
			if(j<rooms[0].length && rooms[i][j+1] == Integer.MAX_VALUE)
			{
				rooms[i][j+1] = rooms[i][j] + 1;
				queue.offer(new int[] {i,j+1});
			}
		}
	}
}
