package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7465_창용마을무리의개수 {
	static boolean[] visit;
	static int[][] arr;
	static int ans, n, m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ans = 0;
			arr = new int[n + 1][n + 1];
			visit = new boolean[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				arr[s][e] = 1;
				arr[e][s] = 1;
			}

			for (int i = 1; i < n + 1; i++) {
				if (!visit[i]) {
					bfs(i);
					ans++;
				}
			}

			System.out.println("#" + tc + " " + ans);
		}
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		visit[s] = true;
		q.add(s);

		while (!q.isEmpty()) {
			int start = q.poll();
			for (int i = 1; i < n + 1; i++) {
				if (arr[start][i] == 1 && !visit[i]) {
					visit[i] = true;
					q.add(i);
				}
			}
		}
	}
}
