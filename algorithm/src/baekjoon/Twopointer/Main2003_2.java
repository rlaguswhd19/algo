package baekjoon.Twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003_2 {
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
		int ans = 0;

		while (e < n) {
			if (sum < m) {
				sum += arr[e++];
			} else {
				if (sum == m) {
					ans++;
				}
				sum -= arr[s++];
			}
		}
		
		while (sum >= m) {
			if (sum == m) {
				ans++;
			}
			
			sum -= arr[s++];
		}

		System.out.println(ans);

	}
}
