package SamSungTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main5373 {
	static char[][][] cube;
	static char[] color = { 'w', 'y', 'r', 'o', 'g', 'b' }; // 위, 아래, 앞, 뒤, 왼, 오
	static int t, n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			setCube();
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				String s = st.nextToken();
				bfs(s.charAt(0), s.charAt(1));
			}
		}
	}

	static void bfs(char face, char dir) {
		int number; // 0 : 위, 1 : 아래, 2 : 앞, 3  : 뒤, 4 : 왼, 5 : 오
		char[] list = new char[3];

		switch (face) {
		case 'U':
			number = 0;
			my(number);
			
			switch (dir) {
			case '+':
				
				break;
			case '-':
				
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				list[i] = cube[2][0][i];
			}
			// 5 -> 3-> 4-> 2
			
			
			break;
		case 'D':
			number = 1;
			my(number);
			break;
		case 'F':
			number = 2;
			my(number);
			break;
		case 'B':
			number = 3;
			my(number);
			break;
		case 'L':
			number = 4;
			my(number);
			break;
		case 'R':
			number = 5;
			my(number);
			break;
		}
	}
	static void my(int number) {
		
	}
	
	static void setCube() {
		cube = new char[6][3][3];
		for (int i = 0; i < 6; i++) {
			char temp = color[i];
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 3; j2++) {
					cube[i][j][j2] = temp;
				}
			}
		}
	}
}
