package Questions;

/*	0-i i-j j-n
 * 
 *  first number : (n-1)/2
 * 
 *  second number : n-j >= i && n-j >=j-i
 */

public class Q306 {
    public static boolean isAdditiveNumber(String num) {
        int n= num.length();        
    	for(int i=1;i<=n/2;i++)
    	{
    		for(int j=1;j<=n-i-j; j++)
    		{
    			if(isValid(i,j,num)) 
    				return true;
    		}
    	}
    	
    	return false;
    }
    
    public static boolean isValid(int i, int j, String num)
    {
    	if(num.charAt(0) == '0' && i> 1) return false;
    	if(num.charAt(i) == '0' && j > 1) return false;
    	String sum = "";
    	Long x1 = Long.parseLong(num.substring(0, i));
    	Long x2 = Long.parseLong(num.substring(i,i+j));
    	
    	for(int start = i+j;start !=num.length();start+=sum.length())
    	{
    		x2 = x1 + x2;
    		x1 = x2 - x1;
    		sum = x2.toString();
    		if(!num.startsWith(sum,start)) return false;
    	}
    	return true;
    }
    
    
	public static void main(String[] args) {
		String num = "21173";
		boolean result = isAdditiveNumber(num);
			System.out.println(result);
		}
}
