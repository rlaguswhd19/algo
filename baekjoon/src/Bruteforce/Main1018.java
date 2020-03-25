package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {
	static int n, m;
	static char[][] map;
	static int ans;
	static char[][] check1 = new char[8][8];
	static char[][] check2 = new char[8][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

		setMap();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isRange(i, j)) {
					check(i, j);
				}
			}
		}

		System.out.println(ans);
	}
	
	static void check(int x, int y) {
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(check1[i][j] != map[x+i][y+j]) {
					sum++;
				}
			}
		}
		
		ans = Math.min(sum, ans);
		
		sum = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(check2[i][j] != map[x+i][y+j]) {
					sum++;
				}
			}
		}
		
		ans = Math.min(sum, ans);
		
	}
	
	static void setMap() {
		int index = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (index % 2 == 0) {
					check1[i][j] = 'W';
				} else {
					check1[i][j] = 'B';
				}
				index++;
			}
			index--;
		}
		
		index = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				if (index % 2 == 0) {
					check2[i][j] = 'B';
				} else {
					check2[i][j] = 'W';
				}
				index++;
			}
			index--;
		}
	}

	static boolean isRange(int x, int y) {
		if (x + 7 < n && y + 7 < m) {
			return true;
		} else {
			return false;
		}
	}
}
