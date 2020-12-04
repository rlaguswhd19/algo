package baekjoon.BinerySerch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(binerySerch(arr, m));
	}

	static long binerySerch(int[] arr, int m) {
		long left = 1;
		long right = 2000000000;
		long mid = 0;
		long sum = 0;

		while (left <= right) {
			mid = (left + right) / 2;
			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > mid) {
					sum += arr[i] - mid;
				}
			}

			if (sum < m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return left - 1;
	}
}
