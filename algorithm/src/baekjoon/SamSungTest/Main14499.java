package baekjoon.SamSungTest;

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
	static int[] dice = new int[7];
//	  	2
//	  4 1 3
//	    5
//	    6

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
		if (!isRange(nx, ny)) {
			return;
		}

		// 주사위 위치 옮기기
		x = nx;
		y = ny;

		// 주사위에나 map에 번호 바꾸기
		int num = map[nx][ny];

		int[] temp = dice.clone();

		switch (k) {
		case 1: // 동
			dice[6] = temp[3];
			dice[3] = temp[1];
			dice[1] = temp[4];
			dice[4] = temp[6];
			break;
		case 2: // 서
			dice[1] = temp[3];
			dice[4] = temp[1];
			dice[6] = temp[4];
			dice[3] = temp[6];
			break;
		case 3: // 북
			dice[6] = temp[2];
			dice[5] = temp[6];
			dice[2] = temp[1];
			dice[1] = temp[5];
			break;
		case 4: // 남
			dice[6] = temp[5];
			dice[5] = temp[1];
			dice[1] = temp[2];
			dice[2] = temp[6];
			break;
		}
		
		//바닥면 바꾸기
		if (map[nx][ny] == 0) {
			map[nx][ny] = dice[6];
		} else {
			dice[6] = map[nx][ny];
			map[nx][ny] = 0;
		}
		System.out.println(dice[1]);
		
	}

	static boolean isRange(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
			return true;
		} else {
			return false;
		}
	}

}
