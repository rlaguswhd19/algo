package Twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;

		while (start < n) {
			if (sum < s) {
				if (end == n) {
					break;
				}

				sum += arr[end++];
			} else {
				sum -= arr[start++];
			}

			if (sum >= s) {
				ans = Math.min(end - start, ans);
			}
		}

		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}
