package Questions;

public class Q167 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int start = 0;
        int end = numbers.length-1;
        
        while(start < end)
        {
        	if(numbers[start]+numbers[end]==target)
        	{
        		res[0] = ++start;
        		res[1] = ++end;
        		break;
        	}
        	else if(numbers[start]+numbers[end]<target) start++;
        	else end--;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		int[] nums = { 1,2,3,4 };
		int target = 6;

		int[] result = new int[2];
		result = twoSum(nums, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}
}
