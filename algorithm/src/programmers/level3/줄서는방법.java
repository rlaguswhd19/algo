package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;

public class 줄서는방법 {
	static int[] arr;
	static long cnt;
	public static void main(String[] args) {
		int n = 3;
		long k = 5;
		System.out.println(Arrays.toString(solution(n, k)));
	}
	
	static int[] solution(int n, long k) {
		arr = new int[n];
		ArrayList<Integer> list = new ArrayList<>();
		int idx = 0;

		long temp = 1;
		for (int i = 1; i < n; i++) {
			temp *= i;
			list.add(i);
		}

		list.add(n);

		int temp_n = n;
		long res = 0;
		k--;
		while (idx < n - 1) {
			res = k / temp;
			arr[idx++] = list.get((int) res);
			list.remove((int) res);
			
			k %= temp;

			temp /= --temp_n;
		}

		arr[idx] = list.get(0);
		return arr;
	}
}
