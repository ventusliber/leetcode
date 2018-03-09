package Questions;

import java.util.LinkedList;
import java.util.Queue;

public class test {
	public void wallsAndGates_dfs(int[][] rooms)
	{
		Queue<int[]> queue = new LinkedList();
		
		for(int i=0;i<rooms.length;i++)
		{
			for(int j=0;j<rooms[0].length;j++)
			{
				if(rooms[i][j] == '0')
				{
					queue.offer(new int[] {i,j});
				}
			}
		}
		
		while(!queue.isEmpty())
		{
			int[] current = queue.poll();
			int x = current[0], y = current[1];
			
			if(x > 0 && rooms[x-1][y] == Integer.MAX_VALUE)
			{
				rooms[x-1][y] = rooms[x][y]+1;
				queue.offer(new int[] {x-1,y});
			}
			if( x<rooms.length-1 && rooms[x+1][y] == Integer.MAX_VALUE)
			{
				rooms[x+1][y] = rooms[x][y]+1;
			}
		}
	}
	
	public void dfs(int[][] rooms, int i , int j , int distance)
	{
		if(i<0 || j<0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < distance) return ;
		rooms[i][j] = distance;
		
		dfs(rooms,i-1,j,distance+1);
		dfs(rooms,i+1,j,distance+1);
		dfs(rooms,i,j+1,distance+1);
		dfs(rooms,i,j-1,distance+1);
	}
	

}
