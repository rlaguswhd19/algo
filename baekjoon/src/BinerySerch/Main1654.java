package BinerySerch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1654 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		binerySerch(arr, n);
	}

	static void binerySerch(int[] arr, int n) {
		long left = 1;
		long right = Integer.MAX_VALUE;
		long mid = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i] / mid;
			}

			if (sum >= n) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(left - 1);
	}
}
