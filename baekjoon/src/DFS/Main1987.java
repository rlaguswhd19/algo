package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1987 {
	static char[][] arr;
	static boolean[][] visit;
	static int result;
	static int r, c;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static ArrayList<Character> way;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		sc.nextLine();
		arr = new char[r][c];
		visit = new boolean[r][c];
		result = 0;
		way = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		dfs(0, 0);
		System.out.println(result);
	}

	static void dfs(int x, int y) {
		if (way.contains(arr[x][y])) {
			result = Math.max(way.size(), result);
			return;
		}
		// 집어넣고
		way.add(arr[x][y]);
		visit[x][y] = true;
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < r && y + dy[i] >= 0 && y + dy[i] < c) {
				if(!visit[x+dx[i]][y+dy[i]]) {
					dfs(x+dx[i], y+dy[i]);
				}
			}
		}
		result = Math.max(way.size(), result);
		way.remove(way.size()-1);
		visit[x][y] = false;
	}
}
