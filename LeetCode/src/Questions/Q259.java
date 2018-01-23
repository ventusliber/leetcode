package Questions;

import java.util.Arrays;

public class Q259 {

	public int threeSumSmaller(int[] nums,int target)
	{
		int res = 0;
		Arrays.sort(nums);
		
		for(int i=0;i<nums.length-2;i++)
		{
			int lo = i+1;
			int hi = nums.length-1;
			while(lo < hi)
			{
				if(nums[i]+nums[lo]+nums[hi]<target)
				{
					res += hi-lo;
					lo++;
				}
				else
					hi--;
			}
		}
		
		return res;
	}
}
