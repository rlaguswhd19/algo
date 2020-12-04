package test.T2020_2.ntech_2020;

public class Solution3 {
	static int[] list = new int[2];
	static int cnt = 0;
	static int max = 0;
	public static void main(String[] args) {
		int[] histogram = { 6, 5, 7, 3, 4, 2 };
		solution(histogram);
	}

	static int solution(int[] histogram) {
		com(0, 0, histogram);
		return max;
	}
	static void com(int idx, int target, int[] histogram) {
		if(idx == 2) {
			int h = list[1] - list[0];
			int w = Math.min(histogram[list[0]], histogram[list[1]]);
			max = Math.max(w*h, max);
		}else if(target == histogram.length) {
			return;
		}else {
			list[idx] = target;
			com(idx + 1, target + 1, histogram);
			com(idx, target + 1, histogram);
		}
	}
}
