package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1865_동철이의일분배 {
	static double[][] arr;
	static boolean[] visit;
	static int n;
	static int[] list;
	static double ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new double[n][n];
			list = new int[n];
			visit = new boolean[n];
			ans = 0;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					arr[i][j] = Double.parseDouble(st.nextToken()) / 100;
				}

			}
			per(0, 1);

			System.out.println("#" + tc + " " + String.format("%.6f", ans * 100));
		}
	}

	static void per(int idx, double sum) {
		if (idx == n) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i]) {
				continue;
			}
			visit[i] = true;
			list[idx] = i;
			per(idx + 1, sum *= arr[idx][i]);
			visit[i] = false;
		}
	}
}
