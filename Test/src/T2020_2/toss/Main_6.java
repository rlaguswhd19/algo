package T2020_2.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6 {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int rowCnt, colCnt;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		boolean colOk = true;
		rowCnt = 0;
		colCnt = 0;
		ans = 0;
		
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();

			if (colOk) {
				colCnt++;
			}

			if (temp.length() == 3) {
				rowCnt++;
				colOk = false;
			}
		}
		rowCnt++;

		map = new int[rowCnt][colCnt];
		s = s.replaceAll(";", " ");
		st = new StringTokenizer(s);
		int r = 0;
		int c = 0;
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			map[r][c++] = num;
			if (c == colCnt) {
				r++;
				c = 0;
			}
		}

		for (int i = 0; i < rowCnt; i++) {
			for (int j = 0; j < colCnt; j++) {
				if (map[i][j] == 1) {
					check(i, j);
				}
			}
		}
		
		System.out.println(ans);
	}

	static void check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!isOk(nx, ny)) {
				continue;
			}
			
			if(map[nx][ny] == 0) {
				ans++;
			}
		}
	}

	static boolean isOk(int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < rowCnt && ny < colCnt) {
			return true;
		} else {
			return false;
		}
	}
}
