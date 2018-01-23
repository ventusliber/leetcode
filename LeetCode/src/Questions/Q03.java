package Questions;

import java.util.HashMap;

public class Q03 {
	public static int lengthOfLongestSubstring(String s) {
		int length = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				start = Math.max(start, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			length = Math.max(length, i - start + 1);
		}
		return length;
	}

	public static void main(String[] args) {
		String s = "abcdabc";
		int length = lengthOfLongestSubstring(s);

		System.out.println(length);
	}
}
