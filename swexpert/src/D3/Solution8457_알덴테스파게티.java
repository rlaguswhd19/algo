package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8457_알덴테스파게티 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ans = 0;
			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(st.nextToken());

				for (int j = b - e; j <= b + e; j++) {
					if (j / num != 0 && j % num == 0) {
						ans++;
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}
}
