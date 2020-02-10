package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2644 {
	static int n, m, start, end;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> q;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		start = sc.nextInt();
		end = sc.nextInt();
		m = sc.nextInt();
		map = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		ans = 0;
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		bfs();
		
		if(ans == 0) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}

	static void bfs() {
		q = new LinkedList<>();
		
		q.add(start);
		
		int count = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int num = q.poll();
				if(num == end) {
					ans = count;
					return;
				}
				visit[num] = true;
				for (int j = 1; j < n+1; j++) {
					if(map[num][j] != 1) {
						continue;
					}
					if(!visit[j]) {
						q.add(j);
					}
				}
			}
			count++;
		}
	}
}
