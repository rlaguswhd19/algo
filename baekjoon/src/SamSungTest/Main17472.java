package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472 {
	static int[][] map;
	static int n, m;
	static int city;
	static Queue<Point> q;
	static boolean[][] visit;
	static ArrayList<Point>[] arr;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		city = 1;
		q = new LinkedList<>();
		visit = new boolean[n][m];
		arr = new ArrayList[7];
		map = new int[n][m];
		
		for (int i = 1; i < 7; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					bfs(i, j);
					city++;
				}
			}
		}
		
		distance = new int[city][city];
		
		for (int i = 1; i < city; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
			bridge(i);
		}
		
		for (int i = 1; i < city; i++) {
			for (int j = 1; j < city; j++) {
				if(distance[i][j] != Integer.MAX_VALUE) {
					
				}
			}
		}
	}
	
	static void kruskal() {
		
	}
	
	static void bridge(int index) {
		System.out.println(index);
		for (int i = 0; i < arr[index].size(); i++) {
			Point p = arr[index].get(i);
			
			for (int j = 0; j < 4; j++) {
				int nx = p.x+dx[j];
				int ny = p.y+dy[j];
				
				if (!isRange(nx, ny)) {
					continue;
				}
				
				if (visit[nx][ny]) {
					continue;
				}
				
				int cnt = 0;
				
				while(true) {
					
					//범위 밖으로 그대로 나가버리면 그만
					if (!isRange(nx, ny)) {
						break;
					}
					
					if(map[nx][ny] == 0) { // 마을이 아니면
						cnt++;
						nx += dx[j];
						ny += dy[j];
					}else { //마을이면?
						if(cnt > 1) {
							System.out.println(index+" -> "+map[nx][ny]+"다리길이  : "+cnt);
							//최솟값을 넣자
							int min = Math.min(distance[index][map[nx][ny]], cnt);
							// 양방향 그래프
							distance[index][map[nx][ny]] = min; 
						}
						break;
					}
				}
			}
		}
		
	}
	
	static void bfs(int x, int y) {
		q.add(new Point(x, y));
		visit[x][y] = true;
		map[x][y] = city;
		arr[city].add(new Point(x, y));
		
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				// 범위안에
				if (!isRange(nx, ny)) {
					continue;
				}
				// 갔던곳 안가기
				if (visit[nx][ny]) {
					continue;
				}
				// 0이면
				if (map[nx][ny] == 0) {
					continue;
				}

				visit[nx][ny] = true;
				q.add(new Point(nx, ny));
				map[nx][ny] = city;
				arr[city].add(new Point(nx, ny));
				
			}
		}
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
			return true;
		} else {
			return false;
		}
	}
	
	static class road{
		int start, end, d;

		public road(int start, int end, int d) {
			super();
			this.start = start;
			this.end = end;
			this.d = d;
		}

		@Override
		public String toString() {
			return "road [start=" + start + ", end=" + end + ", d=" + d + "]";
		}
	}
	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
}
