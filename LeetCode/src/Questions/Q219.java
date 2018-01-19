package Questions;

import java.util.HashSet;
import java.util.Set;

public class Q219 {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
	
	public static void main(String[] args) {
		int[] arrays = { 1,2,3,4,1};
		boolean result = containsNearbyDuplicate(arrays,3);
			System.out.println(result);
		}
}
