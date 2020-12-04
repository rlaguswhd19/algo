package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main12761 {
	static int a, b, n, m, ans;
	static boolean[] visit;
	static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		visit = new boolean[100001];

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		bfs();
	}

	static void bfs() {
		int[] dx = { 1, -1, a, b, -a, -b, a, b };

		q = new LinkedList<>();
		q.add(n);
		visit[n] = true;
		ans = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			
			for (int i = 0; i < size; i++) {
				int num = q.poll();

				if (num == m) {
					System.out.println(ans);
					return;
				}

				for (int j = 0; j < 8; j++) {
					int d = dx[j];
					int next = 0;

					if (j > 5) { // *하기 더하기 빼기
						next = num * d;
					} else {
						next = num + d;
					}

					if (!isRange(next)) {
						continue;
					}

					if (!visit[next]) {
						visit[next] = true;
						q.add(next);
					}
				}
			}
			
			ans++;
		}
	}

	static boolean isRange(int next) {
		if (next >= 0 && next <= 100000) {
			return true;
		} else {
			return false;
		}
	}
}
