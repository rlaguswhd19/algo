package BinerySerch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2512 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int right = 0;
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			right = Math.max(right, num);
		}

		Arrays.sort(arr);
		int m = Integer.parseInt(br.readLine());
		binerySerch(arr, m, right);

	}

	static void binerySerch(int[] arr, int m, int right) {
		int left = 0;
		int mid = 0, sum = 0;

		while (left <= right) {
			mid = (left + right) / 2;

			sum = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] <= mid) {
					sum += arr[i];
				} else {
					sum += mid;
				}
			}

			if (sum > m) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(left - 1);
	}
}
