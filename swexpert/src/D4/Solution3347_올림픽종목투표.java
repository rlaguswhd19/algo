package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution3347_올림픽종목투표 {
	static int[] arr, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int ans = 0;
			int max = 0;
			arr = new int[n];
			cnt = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < m; i++) {
				int num = Integer.parseInt(st.nextToken());
				for (int j = 0; j < n; j++) {
					int cost = arr[j];

					if (num >= cost) {
						cnt[j]++;
						break;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				if (max < cnt[i]) {
					max = cnt[i];
					ans = i;
				}
			}
			
			System.out.println("#" + tc + " " + (ans+1));
		}
	}
}
