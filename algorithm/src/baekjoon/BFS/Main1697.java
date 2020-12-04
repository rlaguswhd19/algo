package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1697 {
	static int n, k, ans;
	static Queue<Integer> q;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		visit = new boolean[100001];

		bfs();

		System.out.println(ans);
	}

	static void bfs() {
		q = new LinkedList<>();

		q.add(n);
		visit[n] = true;
		ans = 0;

		loop: while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int x = q.poll();

				if (x == k) {
					break loop;
				}

				if (x + 1 <= 100000) {
					if (!visit[x + 1]) {
						visit[x + 1] = true;
						q.add(x + 1);
					}
				}

				if (x - 1 >= 0) {
					if (!visit[x - 1]) {
						visit[x - 1] = true;
						q.add(x - 1);
					}
				}

				if (2 * x <= 100000) {
					if (!visit[2 * x]) {
						visit[2 * x] = true;
						q.add(2 * x);
					}
				}
			}
			ans++;
		}
	}
}
