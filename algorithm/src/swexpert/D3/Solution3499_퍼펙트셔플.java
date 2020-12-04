package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3499_퍼펙트셔플 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			String[] arr = new String[n];

			for (int i = 0; i < n; i++) {
				arr[i] = st.nextToken();
			}

			// n = 4 start = 2;
			int s1, s2;
			if (n % 2 == 0) { // 짝수면
				s2 = n / 2;
			} else {
				s2 = n / 2 + 1;
			}

			s1 = 0;
			int cnt = 0;

			StringBuilder sb = new StringBuilder();
			while (cnt < n) {
				if (n % 2 == 0) {
					if (cnt % 2 == 0) {
						sb.append(arr[s1] + " ");
						s1++;
					} else {
						sb.append(arr[s2] + " ");
						s2++;
					}
				} else {
					if (cnt % 2 == 0) {
						sb.append(arr[s1] + " ");
						s1++;
					} else {
						sb.append(arr[s2] + " ");
						s2++;
					}
				}
				cnt++;
			}

			System.out.println("#" + tc + " " + sb.toString());
		}
	}
}
