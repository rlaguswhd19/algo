package swexpert.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution4751_다솔이의다이아몬드장식 {
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			String s = br.readLine();
			int size = 5 + 4 * s.length() - 1;
			map = new char[5][size];

			int col = 0;

			for (int a = 0; a < s.length(); a++) {
				int cnt = 0;

				for (int i = 0; i < 5; i++) {
					for (int j = col; j < col + 5; j++) {
						if (i == 2 && j == col + 2) {
							map[i][j] = s.charAt(a);
						} else if (j == col + 2 - cnt || j == col + 2 + cnt) {
							map[i][j] = '#';
						} else {
							map[i][j] = '.';
						}
					}

					if (i >= 2) {
						cnt--;
					} else {
						cnt++;
					}
				}
				col += 4;
			}

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
}
