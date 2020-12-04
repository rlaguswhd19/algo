package baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main9370_2 {
	static StringTokenizer st;
	static int n, m, t, s, g, h;
	static ArrayList<point>[] list;
	static double[] distance;
	static ArrayList<Integer> goal;
	static PriorityQueue<point> pq;
	static ArrayList<Integer> ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			ans = new ArrayList<>();
			n = Integer.parseInt(st.nextToken());
			list = new ArrayList[n + 1];
			distance = new double[n + 1];
			goal = new ArrayList<>();

			Arrays.fill(distance, Integer.MAX_VALUE);

			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());

			distance[s] = 0;

			for (int i = 1; i < n + 1; i++) {
				list[i] = new ArrayList<>();
			}

			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				if ((a == g && b == h) || (a == h && b == g)) {
					list[a].add(new point(b, d-0.1));
					list[b].add(new point(a, d-0.1));
				}else {
					list[a].add(new point(b, d));
					list[b].add(new point(a, d));
				}
			}
			
			for (int i = 0; i < t; i++) {
				int x = Integer.parseInt(br.readLine().trim());
				goal.add(x);
			}

			dijkstra(s, distance);
			for (int i = 0; i < goal.size(); i++) {
				if(distance[goal.get(i)] % 1 != 0) {
					ans.add(goal.get(i));
				}
			}
			Collections.sort(ans);
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i)+" ");
			}
			System.out.println();
		}
	}

	static void dijkstra(int start, double[] distance) {
		pq = new PriorityQueue<>(new Comparator<point>() {

			@Override
			public int compare(point p1, point p2) {
				if (p1.d < p2.d) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		pq.add(new point(start, 0));

		while (!pq.isEmpty()) {
			point p = pq.poll();

			if (distance[p.next] < p.d) {
				continue;
			}

			for (int i = 0; i < list[p.next].size(); i++) {
				point p2 = list[p.next].get(i);
				int nx = p2.next;
				double nd = p2.d;

				if (distance[nx] > distance[p.next] + p2.d) {
					distance[nx] = distance[p.next] + p2.d;
					pq.add(new point(nx, distance[nx]));
				}
			}
		}
	}

	static class point {
		int next;
		double d;
		
		public point(int next, double d) {
			super();
			this.next = next;
			this.d = d;
		}
		
		@Override
		public String toString() {
			return "point [next=" + next + ", d=" + d + "]";
		}
	}
}
