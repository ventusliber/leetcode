package Questions;

import java.util.Stack;

public class Q739 {
	   public static int[] dailyTemperatures(int[] temperatures) {
	        int[] result = new int[temperatures.length];
	        for(int i=0;i<temperatures.length-1;i++)
	        {
	        	int j=i+1;
	        	int days = j-i;
	        	while(j<temperatures.length && temperatures[i]>=temperatures[j])
	        	{
	        		j++;
	        		if(j==temperatures.length) 
	        			days = 0;
	        		else
	        			days = j-i;
	        	}
	        	result[i]=days;
	        }
	        return result;
	    }
	   
	   public static int[] dailyTemperatures2(int[] temperatures)
	   {
		   int len = temperatures.length;
		   int[] result = new int[len];
		   Stack<Integer> stack = new Stack<Integer>();
		   
		   for(int i=len-1;i>=0;i--)
		   {
			   while(!stack.isEmpty() && temperatures[i]>=temperatures[stack.peek()])stack.pop();
			   result[i] = stack.isEmpty()? 0 : stack.peek()-i;
			   stack.push(i);
		   }
		   
		   return result;
	   }
	   
	   public static void main(String[] args) {
			int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
			int[] result = dailyTemperatures2(temperatures);
			for(int i=0;i<result.length;i++)
			{
				System.out.println(result[i]);
			}
			

		}
}
