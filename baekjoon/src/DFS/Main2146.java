package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2146 {
	static int[][] arr;
	static int[][] map;
//	static Pair[][] map;
	static boolean[][] visit;
	static int n, min;
	static Queue<Pair> q;
	static int[] a = { 1, 0, -1, 0 };
	static int[] b = { 0, 1, 0, -1 };
	static int index = 1, island = 1;
	static boolean isOk;	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		visit = new boolean[n][n];
		q = new LinkedList<>();
		map = new int[n][n];
		min = Integer.MAX_VALUE;
//		map = new Pair[n][n];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && arr[i][j] == 1) {
					dfs(i, j);
					island++;
				}
			}
		}
		
		

		while(!isOk) {
			bfs();
			index++;
		}
		System.out.println(min);
	}
	
	static void print() {
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int x, int y) {
		q.add(new Pair(x, y, island));
		visit[x][y] = true;
		arr[x][y] = island;
		for (int i = 0; i < 4; i++) {
			if (x + a[i] >= 0 && x + a[i] < n && y + b[i] >= 0 && y + b[i] < n) {
				if (!visit[x + a[i]][y + b[i]] && arr[x + a[i]][y + b[i]] == 1) {
					dfs(x + a[i], y + b[i]);
				}
			}
		}
	}
	
	static void bfs() { 
		int size = q.size();
		for (int i = 0; i < size; i++) {
			Pair tmp = q.remove();
			for (int j = 0; j < 4; j++) {
				if (tmp.x + a[j] >= 0 && tmp.x + a[j] < n && tmp.y + b[j] >= 0 && tmp.y + b[j] < n) {
					//섬이 아니고 
					if(!visit[tmp.x+a[j]][tmp.y+b[j]]) {
						// 0이면
						if(map[tmp.x+a[j]][tmp.y+b[j]] == 0) {
							q.add(new Pair(tmp.x+a[j], tmp.y+b[j], tmp.index));
							map[tmp.x+a[j]][tmp.y+b[j]] = index;
							arr[tmp.x+a[j]][tmp.y+b[j]] = tmp.index;
						// 0이아니면
						}else {
							//다른 섬에서 온 길이면
							if(arr[tmp.x+a[j]][tmp.y+b[j]] != tmp.index) {
								min = Math.min(map[tmp.x+a[j]][tmp.y+b[j]] + map[tmp.x][tmp.y], min);
								isOk = true;
							}
						}
					}
				}
			}
		}
	}
	
	static class Pair{
		int x, y, index;

		public Pair(int x, int y, int index) {
			super();
			this.x = x;
			this.y = y;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + ", index=" + index + "]";
		}
	}
}
