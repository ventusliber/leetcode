package Questions;


/*
 * root: 1 ---- left:0 right:2   f(0) * f(2)
 * root: 2 ---- left:1 right:1   f(1) * f(1)
 * root: 3 ---- left:2 right:0   f(2) * f(0)
 * 
 * f(n)= f(0)*f(n-1) + f(1) * f(n-2) +....+ f(n-1)*f(0)
 */

public class Q96 {
    public static int numTrees(int n) {
        int[] res = new int[n+1];
        res[0] = 1;
        for(int i=1;i<=n;i++)
        {
        	for(int j=0;j<i;j++)
        	{
        		res[i] += res[j] * res[i-1-j];
        	}
        }
        return res[n];
    }
    
	public static void main(String[] args) {
		int n = 3;
		int result = numTrees(n);
			System.out.println(result);
		}
}
