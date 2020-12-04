package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2842_1 {
	static int[][] hight;
	static int[][] distance;

	static PriorityQueue<point> pq;
	static int px, py, n;
	static ArrayList<point> list;
	static ArrayList<int[][]> arr;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		hight = new int[n][n];
		arr = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			s.split(" ");
			for (int j = 0; j < n; j++) {
				char temp = s.charAt(j);
				if (temp == 'P') {
					px = i;
					py = j;
				} else if (temp == 'K') {
					list.add(new point(i, j));
				}
			}
		}
		// 첫뻔째가 집
		list.add(0, new point(px, py));

		System.out.println(list);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				hight[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < list.size(); i++) {
			pq = new PriorityQueue<>(new Comparator<point>() {
				@Override
				public int compare(point p1, point p2) {
					if (p1.x - p1.y > p2.x - p2.y) {
						return -1;
					} else {
						return 1;
					}
				}
			});

			// distance 초기화
			distance = new int[n][n];
			for (int j = 0; j < 1; j++) {
				Arrays.fill(distance[j], Integer.MAX_VALUE);
			}

			point p = list.get(i);
			distance[p.x][p.y] = 0;

			pq.add(new point(p.x, p.y));

			dijkstra();

			for (int j = 0; j < n; j++) {
				System.out.println(Arrays.toString(distance[j]));
			}
			System.out.println();

			arr.add(distance);
		}
	}

	static void dijkstra() {

		while (!pq.isEmpty()) {
			point p = pq.poll();

			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				
				if(distance[nx][ny] > hight[nx][ny]) {
					
				}
			}
		}
	}

	static boolean isRange(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < n) {
			return true;
		} else {
			return false;
		}
	}

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + "]";
		}
	}
}
