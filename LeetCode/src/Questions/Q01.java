package Questions;

import java.util.HashMap;

public class Q01 {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int prev = target - nums[i];
			if (map.containsKey(prev)) {
				result[0] = map.get(prev);
				result[1] = i;
			}
			map.put(nums[i], i);
		}
		return result;

	}

	public static void main(String[] args) {
		int[] nums = {3,2,4};
		int target = 6;
		
		int[] result = new int[2];
		result = twoSum(nums,target);
		for(int i=0;i<result.length;i++)
		{
			System.out.println(result[i]);
		}

	}
}
