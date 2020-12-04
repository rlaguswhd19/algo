package baekjoon.SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17471 {
	static int n;
	static int[] people;
	static int[][] map;
	static int[] result;
	static boolean[] visit;
	static Queue<Integer> q;
	static int ans, whole;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		people = new int[n + 1];
		map = new int[n + 1][n + 1];
		result = new int[n + 1];
		ans = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			whole += people[i];
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][num] = 1;
			}
		}
		per(1);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static void per(int cnt) {
		if (cnt == n + 1) {
			if (bfs()) {
				int sum = 0;
				for (int i = 0; i < result.length; i++) {
					if (result[i] == 1) {
						sum += people[i];
					}
				}

				ans = Math.min(ans, Math.abs(sum - (whole - sum)));

			}
			return;
		}

		for (int i = 0; i < 2; i++) {
			result[cnt] = i;
			per(cnt + 1);
		}
	}

	static boolean bfs() {
		visit = new boolean[n + 1];
		q = new LinkedList<>();
		for (int i = 1; i < n + 1; i++) {
			if (result[i] == 1) {
				q.add(i);
				visit[i] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			int num = q.poll();
			for (int i = 0; i < n; i++) {
				if (visit[i]) {
					continue;
				}

				if (map[num][i] == 1 && result[i] == 1) {
					q.add(i);
					visit[i] = true;
				}
			}
		}

		for (int i = 1; i < visit.length; i++) {
			if ((result[i] == 0 && !visit[i]) || (result[i] == 1 && visit[i])) {
				continue;
			} else {
				return false;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (result[i] == 0) {
				q.add(i);
				visit[i] = true;
				break;
			}
		}

		while (!q.isEmpty()) {
			int num = q.poll();
			for (int i = 1; i < n+1; i++) {
				if (visit[i]) {
					continue;
				}

				if (map[num][i] == 1 && result[i] == 0) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		
		for (int i = 1; i < visit.length; i++) {
			if (!visit[i]) {
				return false;
			}
		}

		return true;
	}
}
