package Questions;

public class Q459 {
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();      
        for(int i=1;i<=n/2;i++)
        {
            if(n%i == 0)
            {
			    StringBuilder sb = new StringBuilder();
                String strsub = s.substring(0,i);
                for(int j=0;j<n/i;j++)
                {
                   sb.append(strsub);
                }
                 if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		String str = "abcdabcd";
		boolean result = repeatedSubstringPattern(str);
			System.out.println(result);
		}
}
