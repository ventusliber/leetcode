package Questions;

import java.util.Arrays;

public class Q16 {
	public static int threeSumClosest(int[] nums, int target) {
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int lo = i + 1, hi = nums.length - 1;
			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum > target)
					hi--;
				else
					lo++;

				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] arrays = { -1, 2, 1, -4 };
		int target = 1;
		int result = threeSumClosest(arrays, target);
		System.out.println(result);
	}

}
