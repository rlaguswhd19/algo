package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9372 {
	static int n, m;
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static Queue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new ArrayList[n + 1];
			visit = new boolean[n + 1];

			for (int i = 1; i < n + 1; i++) {
				map[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a].add(b);
				map[b].add(a);
			}

			bfs();

		}
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(1);
		visit[1] = true;

		int count = 0;
		while (!q.isEmpty()) {
			int num = q.poll();
			for (int i = 0; i < map[num].size(); i++) {
				int next = map[num].get(i);

				if (!visit[next]) {
					q.add(next);
					visit[next] = true;
				}
			}
			count++;
		}

		System.out.println(count - 1);
	}
}
