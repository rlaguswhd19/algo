package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution4050_재관이의대량할인 {
	static Integer[] arr;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			arr = new Integer[n];
			ans = 0;

			StringTokenizer st = new StringTokenizer(br.readLine());

			int idx = 0;
			while (st.hasMoreTokens()) {
				arr[idx++] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, Collections.reverseOrder());
			for (int i = n - 1; i >= 0; i--) {
				if (i % 3 == 2) {
					continue;
				}

				ans += arr[i];
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
