package Questions;

import java.util.HashMap;

/*
 * A + B + C + D = 0
 * A + B = - C - D
 */
public class Q454 {
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int res = 0;
        
        for(int a : A)
        {
        	for(int b: B)
        	{
        		int sum = a+b;
        		map.put(sum, map.getOrDefault(sum, 0)+1);
        	}
        }
        
        for(int c: C)
        {
        	for(int d :D)
        	{
        		int sum2 = -c -d ;
        		res += map.getOrDefault(sum2, 0);
        	}
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		int[] a = {1,2 };
		int[] b = {-2,-1 };
		int[] c = {-1,0 };
		int[] d = {0,1 };
		
		int result = fourSumCount(a,b,c,d);
			System.out.println(result);
	}

}
