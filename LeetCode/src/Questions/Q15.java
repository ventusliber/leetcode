package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q15 {
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int target = 0;
        for(int i=0;i<nums.length-2;i++)
        {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]))
            {
                int lo=i+1, hi=nums.length-1, sum= target-nums[i];
                while(lo<hi)
                {
                    if(nums[lo]+nums[hi] == sum)
                    {
                        result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                        while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi-1]) hi--;
                        lo++;
                        hi--;
                    }
                    else if(nums[lo]+nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return result;
	}

	public static void main(String[] args) {
		int[] arrays = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result = threeSum(arrays);
		for (List<Integer> r : result) {
			for (int n : r) {
				System.out.print(n + " ");
			}

			System.out.println();
		}
	}

}
