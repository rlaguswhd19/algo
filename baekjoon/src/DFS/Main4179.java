package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main4179 {
	static int r, c;
	static char[][] map;
	static Queue<point> fq, mq;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visit;
	static int ans = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		map = new char[r][c];
		visit = new boolean[r][c];
		fq = new LinkedList<>();
		mq = new LinkedList<>();

		sc.nextLine();
		for (int i = 0; i < r; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'J') {
					map[i][j] = '.';
					visit[i][j] = true;
					mq.add(new point(i, j));
				} else if (map[i][j] == 'F') {
					fq.add(new point(i, j));
				}
			}
		}
		
		bfs();

		if (ans == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		int cnt = 0;
		
		loop : while(!mq.isEmpty()) {
			int size = fq.size();
			for (int i = 0; i < size; i++) {
				point p = fq.poll();
				for (int j = 0; j < 4; j++) {
					if (p.r + dx[j] >= 0 && p.r + dx[j] < r && p.c + dy[j] >= 0 && p.c + dy[j] < c) {
						if (map[p.r + dx[j]][p.c + dy[j]] == '.') {
							map[p.r + dx[j]][p.c + dy[j]] = 'F';
							fq.add(new point(p.r + dx[j], p.c + dy[j]));
						}
					}
				}
			}
			
			size = mq.size();
			for (int i = 0; i < size; i++) {
				point p = mq.poll();
				for (int j = 0; j < 4; j++) {
					if (p.r + dx[j] >= 0 && p.r + dx[j] < r && p.c + dy[j] >= 0 && p.c + dy[j] < c) {
						if(!visit[p.r+dx[j]][p.c+dy[j]] && map[p.r+dx[j]][p.c+dy[j]] == '.') {
							visit[p.r+dx[j]][p.c+dy[j]] = true;
							mq.add(new point(p.r+dx[j], p.c+dy[j]));
						}
					}else {
						ans = ++cnt;
						break loop;
					}
				}
			}
			cnt++;
		}
		
	}

	static class point {
		int r, c;

		public point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "point [r=" + r + ", c=" + c + "]";
		}

	}
}
