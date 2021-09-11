package baekjoon.Twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1806_복습 {
	static int n, m, s = 0, e = 0, sum = 0, ans = Integer.MAX_VALUE;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());

		int idx = 0;
		while (st.hasMoreTokens()) {
			arr[idx++] = Integer.parseInt(st.nextToken());
		}

		while (s < n) {
			if (sum < m) {
				if(e == n) {
					break;
				}
				
				sum += arr[e++];
			}else {
				ans = Math.min(ans, e-s);
				sum -= arr[s++];
			}
		}
		
		System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
	}
}
