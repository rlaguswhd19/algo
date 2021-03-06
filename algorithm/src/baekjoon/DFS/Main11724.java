package baekjoon.DFS;

import java.util.Scanner;

public class Main11724 {
	static int[][] arr;
	static boolean[] visit;
	static int n, m;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //정점의 갯수
		m = sc.nextInt(); //간선의 갯수
		
		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		count = 0;
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		
		for (int i = 1; i <= n; i++) {
			if(!visit[i]) {
				DFS(i);
				count++;
			}
		}
		System.out.println(count);
	}
	static void DFS(int i) {
		visit[i] = true;
		for (int j = 1; j < n+1; j++) {
			if(!visit[j] && arr[i][j] == 1) {
				DFS(j);
			}
		}
	}
}
