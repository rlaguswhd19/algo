package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1967 {
	static ArrayList<Point>[] arr;
	static boolean[] visit;
	static int n;
	static Queue<Point> q;
	static int max;
	static int index;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		arr = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			arr[a].add(new Point(b, d));
			arr[b].add(new Point(a, d));
		}
		bfs(1);
		bfs(index);
		System.out.println(max);
	}

	static void bfs(int start) {
		visit = new boolean[n + 1];
		q = new LinkedList<>();
		max = 0;

		q.add(new Point(start, 0));
		visit[start] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			if (max < p.d) {
				max = p.d;
				index = p.now;
			}
			int now = p.now;
			int cost = p.d;

			for (int i = 0; i < arr[now].size(); i++) {
				Point p2 = arr[now].get(i);
				int next = p2.now;
				int ncost = p2.d;

				if (visit[next]) {
					continue;
				}

				q.add(new Point(next, cost + ncost));
				visit[next] = true;
			}
		}
	}

	static class Point {
		int now, d;

		public Point(int now, int d) {
			super();
			this.now = now;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Point [now=" + now + ", d=" + d + "]";
		}
	}
}
