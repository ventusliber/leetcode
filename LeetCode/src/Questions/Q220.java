package Questions;

import java.util.HashMap;
import java.util.Map;

public class Q220 {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (k <= 0 || t < 0)
			return false;
		Map<Long, Long> map = new HashMap<Long, Long>();
		for (int i = 0; i < nums.length; i++) {
			long div = t + 1;
			long key = (long) nums[i] / div;
			if ((long) nums[i] < 0)
				key--;
			if (map.containsKey(key) || (map.containsKey(key + 1) && map.get(key + 1) - (long) nums[i] <= t)
					|| (map.containsKey(key - 1) && (long) nums[i] - map.get(key - 1) <= t))
				return true;
			if (i >= k)
				map.remove((long) nums[i - k] / div);
			map.put(key, (long) nums[i]);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 10, 25, 28, 61, 102, 133 };
		int[] nums2 = { -3, 3, -10 };
		boolean result = containsNearbyAlmostDuplicate(nums, 5, 2);
		boolean result2 = containsNearbyAlmostDuplicate(nums2, 2, 4);
		System.out.println(result);
		System.out.println(result2);
	}
}
