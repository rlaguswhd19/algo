package baekjoon.DFS;

import java.util.Scanner;

public class Main9205 {

	static point start, end;
	static point[] cu;
	static boolean[] visit;
	static boolean ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			
			int n = sc.nextInt();
			cu = new point[n];
			visit = new boolean[n];
			ans = false;
			
			for (int i = 0; i < n + 2; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if (i == 0) {
					start = new point(x, y);
				} else if (i == n + 1) {
					end = new point(x, y);
				} else {
					cu[i-1] = new point(x,y);
				}
			}
			dfs(start);
			if(ans) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
		}
	}

	static void dfs(point now) {
		if(Math.abs(now.x - end.x) + Math.abs(now.y - end.y) <= 1000) {
			ans = true;
			return;
		}
		
		for (int i = 0; i < cu.length; i++) {
			if(ans) {
				break;
			}
			
			if(!visit[i]) {
				point p = cu[i];
				if (Math.abs(now.x - p.x) + Math.abs(now.y - p.y) <= 1000) {
					visit[i] = true;
					dfs(p);
				}
			}
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
