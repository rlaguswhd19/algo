package baekjoon.Twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2230 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int s = 0;
		int e = 0;
		int ans = Integer.MAX_VALUE;

		while (s < n) {
			if (arr[e] - arr[s] < m) {
				e++;
				
				if (e == n) {
					break;
				}
			} else {
				s++;
				
				if(s == n) {
					break;
				}
			}

			if (arr[e] - arr[s] >= m) {
				ans = Math.min(arr[e] - arr[s], ans);
			}
		}
		
		System.out.println(ans);
	}
}
