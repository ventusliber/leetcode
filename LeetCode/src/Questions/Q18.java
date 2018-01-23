package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * 
 * [-2,-1,0,0,1,2] 0
 */
public class Q18 {
	  public List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if(nums.length < 4) return res;
	        Arrays.sort(nums);
	        
	        for(int i=0;i<nums.length-3;i++)
	        {
	        	if(i==0 || (i>0 && nums[i]!=nums[i-1]))
	        	{
	        		for(int j=i+1;j<nums.length-2;j++)
	        		{
	        			if(j==i+1 || (j>i+1 && nums[j]!=nums[j-1]))
	        			{
	        				int lo = j+1,hi=nums.length-2;
	        				while(lo<hi)
	        				{
	        					int sum = nums[i]+nums[j]+nums[lo]+nums[hi];
	        					if(sum == target)
	        					{
	        						res.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
	        						while(lo<hi && nums[lo]==nums[lo+1]) lo++;
	        						while(lo<hi && nums[hi]==nums[hi-1]) hi--;
	        						lo++;
	        						hi--;
	        					}
	        					else if (sum < target) lo++;
	        					else hi--;
	        				}
	        			}
	        		}
	        	}
	        }
	        return res;
	    }

}
