package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Main5719_2 {
	static int n, start, end;
	static int[][] map;
	static boolean[] visit;
	static int[] distance;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			n = sc.nextInt();
			int m = sc.nextInt();
			
			if(n == 0 && m == 0) {
				break;
			}
			
			start = sc.nextInt();
			end = sc.nextInt();
			map = new int[n][n];
			visit = new boolean[n];
			
			for (int i = 0; i < m; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int p = sc.nextInt();
				map[u][v] = p;
			}
			
			distance = new int[n];
			
			for (int i = 0; i < n; i++) {
				if(i == start) {
					distance[i] = 0;
				}else {
					if(map[start][i] == 0) {
						distance[i] = Integer.MAX_VALUE;
					}else {
						distance[i] = map[start][i];
					}
				}
			}
			System.out.println(Arrays.toString(distance));
			visit[start] = true;
			
			dijkstra();
		}
	}
	static void dijkstra() {
		for (int i = 1; i < n; i++) {
			
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for (int j = 1; j < n; j++) {
				if(!visit[j] && distance[j] != Integer.MAX_VALUE) {
					if(distance[j] < min) {
						min = distance[j];
						index = j;
					}
				}
			}
			
			visit[index] = true;
			
			for (int j = 1; j < n; j++) {
				if(!visit[j] && map[index][j] != 0) {
					if(distance[j] > distance[index]+map[index][j]) {
						distance[j] = distance[index]+map[index][j];
					}
				}
			}
			
			System.out.println(Arrays.toString(distance));
		}
	}
}
