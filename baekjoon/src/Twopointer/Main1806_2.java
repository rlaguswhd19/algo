package Twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1806_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int s = 0;
		int e = 0;
		int sum = 0;
		int ans = Integer.MAX_VALUE;

		while (s < n) {
			if (sum < m) {
				if (e == n) {
					break;
				}

				sum += arr[e++];
			} else {
				ans = Math.min(ans, e - s);
				sum -= arr[s++];
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}
