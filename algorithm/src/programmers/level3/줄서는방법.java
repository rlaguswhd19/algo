package algo;

import java.util.ArrayList;
import java.util.Arrays;

public class 줄서는방법 {
	static int[] arr;
	static long cnt;

	public static void main(String[] args) {
		int n = 3;
		long k = 2;
		solution(n, k);
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
		while (idx < n - 1) {
			res = k / temp;
			System.out.println(k + " " + temp);
			if (k % temp == 0) {
				arr[idx++] = list.get((int) res - 1);
				list.remove((int) res - 1);
				k /= temp;
			} else {
				arr[idx++] = list.get((int) res);
				list.remove((int) res);

				k = k / temp + k % temp;
			}

			temp /= --temp_n;
		}

		arr[idx] = list.get(0);
		System.out.println(list);
		System.out.println(Arrays.toString(arr));
		return arr;
	}
}
