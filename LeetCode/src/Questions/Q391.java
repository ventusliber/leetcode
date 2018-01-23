package Questions;

import java.util.HashSet;

public class Q391 {
	public boolean isRectangleCover(int[][] rectangles) {
		if (rectangles.length == 0 || rectangles[0].length == 0)
			return false;

		int x1 = Integer.MAX_VALUE;
		int y1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE;
		int y2 = Integer.MIN_VALUE;

		int area = 0;
		HashSet<String> hash = new HashSet<String>();
		for (int[] rect : rectangles) {
			x1 = Math.min(x1, rect[0]);
			x2 = Math.max(x2, rect[2]);
			y1 = Math.min(y1, rect[1]);
			y2 = Math.max(y2, rect[3]);

			area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

			String s1 = rect[0] + " " + rect[1];
			String s2 = rect[2] + " " + rect[1];
			String s3 = rect[0] + " " + rect[3];
			String s4 = rect[2] + " " + rect[3];

			if (!hash.add(s1))
				hash.remove(s1);
			if (!hash.add(s2))
				hash.remove(s2);
			if (!hash.add(s3))
				hash.remove(s3);
			if (!hash.add(s4))
				hash.remove(s4);
		}

		if (hash.size() != 4 || !hash.contains(x1 + " " + y1) || !hash.contains(x2 + " " + y1)
				|| !hash.contains(x1 + " " + y2) || !hash.contains(x2 + " " + y2))
			return false;

		return area == (x2 - x1) * (y2 - y1);
	}

}
