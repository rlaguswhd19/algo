package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1860_진기의최고급붕어빵 {
	static int n, m, k, cnt;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[11112];

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			boolean isOk = true;
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());
				arr[num]++;
			}

			for (int i = 0; i < 11112; i++) {
				if (i != 0) {
					if (i % m == 0) {
						cnt += k;
					}
				}

				if (arr[i] != 0) {
					cnt -= arr[i];

					if (cnt < 0) {
						isOk = false;
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + (isOk ? "Possible" : "Impossible"));
		}
	}
}
