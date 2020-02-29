package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14499 {
	static int[][] map;
	static int n, m, x, y, k;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[][] number = 
			{{2, 3, 4, 1}, //1 동서북남
			{2, 3, 0, 5},
			{3, 0, 1, 4},
			{0, 2, 4 ,1},
			{2, 3 ,5 ,0},
			{2, 3, 1, 4}};
	static int[] dice = new int[6];
	static int down = 5;
	static int[] up = {5, 4, 3, 2, 1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			dfs(Integer.parseInt(st.nextToken()));
		}
	}

	static void dfs(int k) {
		int nx = x + dx[k - 1];
		int ny = y + dy[k - 1];
		System.out.println(nx+" "+ny);
		if (!isRange(nx, ny)) {
			return;
		}
		
		// 주사위 위치 옮기기
		x = nx;
		y = ny;
		
		// 주사위 밑면 바꾸기
		down = number[down][k-1];
		
		//주사위에나 map에 번호 바꾸기
		int num = map[nx][ny];
		if (num == 0) { // 주사위의 번호가 맵에 찍힌다.
			map[nx][ny] = dice[down];
			System.out.println("down : "+(down+1));
		} else { // 맵의 번호가 주사위에 찍힌다.
			dice[down] = map[nx][ny];
			map[nx][ny] = 0;
			System.out.println("down : " +(down+1));
		}
		System.out.println("ans : "+dice[up[down]]);
		System.out.println(Arrays.toString(dice));
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
			return true;
		} else {
			return false;
		}
	}

}
