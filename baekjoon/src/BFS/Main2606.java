package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2606 {
	static int n, m;
	static int[][] map;
	static Queue<Integer> q;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			map[s][e] = 1;
			map[e][s] = 1;
		}
		
		bfs();
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(1);
		visit[1] = true;

		int cnt = -1;

		while (!q.isEmpty()) {
			int num = q.poll();
			cnt++;

			for (int i = 1; i < n + 1; i++) {
				if (map[num][i] == 0) {
					continue;
				}

				if (visit[i]) {
					continue;
				}

				q.add(i);
				visit[i] = true;
			}
		}

		System.out.println(cnt);
	}
}
