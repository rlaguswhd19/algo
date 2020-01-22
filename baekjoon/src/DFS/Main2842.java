package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2842 {
	static char[][] map;
	static int[][] hight;
	static ArrayList<int[][]> arr;
	static int[][] distance;
	static PriorityQueue<point> pq;
	static int px, py, n;
	static ArrayList<point> list;
	static int ans = Integer.MAX_VALUE;
	static int[] dx = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 1, 0, -1, 1, -1, 1, -1 };
	static boolean[] visit;
	static ArrayList<point> temp = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		map = new char[n][n];
		hight = new int[n][n];
		arr = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			s.split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'P') {
					px = i;
					py = j;
				} else if (map[i][j] == 'K') {
					list.add(new point(i, j));
				}
			}
		}
		// 첫뻔째가 집
		list.add(0, new point(px, py));
		visit = new boolean[list.size()];
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
					if (p1.value < p2.value) {
						return -1;
					} else {
						return 1;
					}
				}
			});

			// distance 초기화
			distance = new int[n][n];
			for (int j = 0; j < n; j++) {
				Arrays.fill(distance[j], Integer.MAX_VALUE);
			}

			point p = list.get(i);
			distance[p.x][p.y] = 0;

			pq.add(new point(p.x, p.y, 0));

			dijkstra();

			for (int j = 0; j < n; j++) {
				System.out.println(Arrays.toString(distance[j]));
			}
			System.out.println();

			arr.add(distance);
		}

		temp.add(new point(px, py, 0));
		for (int i = 1; i < list.size(); i++) {
			visit[i] = true;
			point p = list.get(i);
			temp.add(new point(p.x, p.y, arr.get(0)[p.x][p.y]));
			dfs(i, 1, arr.get(0)[p.x][p.y]);
			temp.remove(temp.size()-1);
			visit[i] = false;
		}
		System.out.println(ans);
	}

	static void dfs(int index, int count, int sum) {
		if (ans < sum) {
			return;
		}

		if (count == list.size() - 1) {
			System.out.println(temp);
			System.out.println(sum+arr.get(index)[px][py]);
			ans = Math.min(ans, sum + arr.get(index)[px][py]);
			return;
		}

		for (int i = 1; i < list.size(); i++) {
			point p = list.get(i);

			if (!visit[i]) {
				visit[i] = true;
				temp.add(new point(p.x, p.y, arr.get(index)[p.x][p.y]));
				dfs(i, count + 1, sum + arr.get(index)[p.x][p.y]);
				temp.remove(temp.size()-1);
				visit[i] = false;
			}
		}
	}

	static void dijkstra() {

		while (!pq.isEmpty()) {
			point p = pq.poll();

			if (p.value > distance[p.x][p.y]) {
				continue;
			}

			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (isRange(nx, ny)) {
					if (distance[nx][ny] > distance[p.x][p.y] + Math.abs(hight[p.x][p.y] - hight[nx][ny])) {
						distance[nx][ny] = distance[p.x][p.y] + Math.abs(hight[p.x][p.y] - hight[nx][ny]);
						pq.add(new point(nx, ny, distance[nx][ny]));
					}
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
		int x, y, value;

		public point(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
			this.value = 0;
		}

		@Override
		public String toString() {
			return "point [x=" + x + ", y=" + y + ", value=" + value + "]";
		}

	}
}
