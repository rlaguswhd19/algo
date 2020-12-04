package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main5014 {
	static int f, s, g, u, d;
	static boolean[] visit;
	static Queue<Integer> q;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();

		visit = new boolean[f + 1];

		bfs();
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		}else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(s);
		visit[s] = true;

		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				int up = num + u;
				int down = num - d;
				if(num == g) {
					ans = count;
					return;
				}
				
				if (isRange(up)) {
					if (!visit[up]) {
						visit[up] = true;
						q.add(up);
					}
				}

				if (isRange(down)) {
					if (!visit[down]) {
						visit[down] = true;
						q.add(down);
					}
				}
			}
			count++;
		}
	}

	static boolean isRange(int num) {
		if (num >= 1 && num <= f) {
			return true;
		} else {
			return false;
		}
	}
}
