package Questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q217 {
	public static boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

	public static boolean containsDuplicate2(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arrays = { -1, 2, -4, 1, -4 };
		boolean result = containsDuplicate(arrays);
		System.out.println(result);
	}
}
