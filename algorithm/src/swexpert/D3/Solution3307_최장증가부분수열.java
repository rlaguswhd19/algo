package swexpert.D3;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int ans = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < arr.length; i++) {

				int cnt = 1;

				if (ans > arr.length - i + 1) {
					break;
				}

				int num = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					if (num <= arr[j]) {
						num = arr[j];
						cnt++;
					} else {
						break;
					}
				}

				ans = Math.max(ans, cnt);
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
