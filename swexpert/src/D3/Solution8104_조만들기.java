package D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8104_조만들기 {
	static int[] ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			ans = new int[k];

			int grade = 1;
			boolean isOk = true;
			while (grade <= n * k) {
				if (isOk) {
					for (int i = 0; i < k; i++) {
						ans[i] += grade++;
					}
					isOk = false;
				} else {
					for (int i = k - 1; i >= 0; i--) {
						ans[i] += grade++;
					}
					isOk = true;
				}
				
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int i = 0; i < k; i++) {
				sb.append(ans[i] + " ");
			}

			System.out.println(sb);
		}
	}
}
